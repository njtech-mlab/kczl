package cn.edu.njut.communication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.MessageLog;
import cn.edu.njut.entity.MessageUnsent;
import cn.edu.njut.entity.SchoolStudent;

public class MsgServer extends Thread{
	private int port = 8020;
	private boolean done = false;
	private ServerSocketChannel serverChannel;
	private Selector selector;
	private Map<String, SocketChannel> allClients = new HashMap<String, SocketChannel>();
	private Charset charset = Charset.forName("UTF-8");
	private ServerMonitor serverMonitor = new ServerMonitor(allClients);
	private Dao dao = new Dao();
	
	static{
		new MsgServer().start();
	}
	
	private void startServer() throws IOException {
		serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket server = serverChannel.socket();
		server.bind(new InetSocketAddress(port));
		selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		serverMonitor.start();
	}
	
	/*
	private void stopServer() throws IOException {
		done = true;
		serverChannel.close();
	}
	*/
	
	public void run() {
		try{
			retrieveDsts("计算机科学与技术(软件班)",2011);
			startServer();
		}catch(Exception e){
			System.out.println("Can't start server:"+e);
			return;
		}
		
		while(!done) {
			try{
				selector.select();
			}catch(Exception e){
				System.out.println("Server error:"+e);
				return;
			}
			
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while(it.hasNext()) {
				SelectionKey key = (SelectionKey)it.next();
				if(key.isAcceptable()) {
					try{
						handleServer(key);
					}catch(Exception e){
						e.printStackTrace();
						key.cancel();
					}
				}
				
				if(key.isReadable()) {
					try{
						handleClient(key);
					}catch(Exception e){
						e.printStackTrace();
						key.cancel();
					}
				}
				
				it.remove();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleServer(SelectionKey key) throws IOException {
		SocketChannel sc = serverChannel.accept();
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
	}
	
	private void handleClient(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buf = ByteBuffer.allocateDirect(512);
		channel.read(buf);
		buf.flip();
		CharBuffer charbuf = charset.decode(buf);
		String input = charbuf.toString();
		String[] str = input.split("\f");
		if(str[2].equals("false")) {
			 allClients.put(str[1], channel);
		} else{
				String destination = str[0];
				SocketChannel dst = (SocketChannel) allClients.get(destination);
				String sender = str[1];
				String registered = "true";
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance();
				String time = dateFormat.format(date);
				String content = str[3];
				String message = sender + '\f' + registered + '\f' + time + '\f' + content;
			try {
				try {
					MessageLog log = new MessageLog(sender, destination, time, content);
					dao.save(log);
				} catch (Exception e) {
					e.printStackTrace();
				}
				byte[] bytes = charset.encode(message).array();
				buf.flip();
				buf.clear();
				buf.put(bytes);
				buf.flip();
				dst.write(buf);
			} catch (Exception e) {
				try {
					MessageUnsent unsent = new MessageUnsent(sender, destination, time, content);
					dao.save(unsent);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}
	
	private String[] retrieveDsts(String fieldname, Integer grade) {
		String hql = "FROM SchoolStudent ss WHERE ss.field.fieldname='" + fieldname + "' AND ss.grade<=" + grade + "ORDER BY ss.qareference ASC";
		@SuppressWarnings("unchecked")
		List<SchoolStudent> ss = (List<SchoolStudent>) dao.getByHql(hql);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Random random = new Random();
		for(int n=0;n<10;n++){
			int temp = 0;
			for(int i=1; i<=10; i++)
				temp += (int)(random.nextFloat() * ss.size()) / i;
			temp /= 10;
			map.put(ss.get(temp).getSchoolnumber(), temp);
		}
		
		Set<String> set = map.keySet();
		String[] dsts = new String[set.size()];
		Iterator<String> it = set.iterator();
		int num = 0;
		while(it.hasNext()) {
			dsts[num] = (String) it.next();
			num++;
		}
		
		return dsts;
	}
}






