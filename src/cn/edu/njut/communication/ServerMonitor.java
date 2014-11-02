package cn.edu.njut.communication;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ServerMonitor extends Thread{
	private Map<String, SocketChannel> allClients;
	private Set set;
	private Iterator it;
	private Entry entry;
	private SocketChannel channel;
	private ByteBuffer buf;
	private byte[] testBytes;
	private String str;
	
	public ServerMonitor(Map<String, SocketChannel> allClients) {
		this.allClients = allClients;
		buf = ByteBuffer.allocateDirect(100);
		str = "This is a test String.";
		testBytes = str.getBytes();
		buf.put(testBytes);
	}
	
	public void run(){
		while(true) {
			if(!allClients.isEmpty()) {
				set = allClients.entrySet();
				it = set.iterator();
				while(it.hasNext()) {
					buf.clear();
					buf.put(testBytes);
					//System.out.println("[in loop] allClients size: "+allClients.size());
					try {
						entry = (Entry) it.next();
						channel = (SocketChannel) entry.getValue();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					buf.flip();
					try{
						channel.write(buf);
						buf.flip();
					} catch(Exception e) {
						//channel.close();
						it.remove();
						buf.flip();
					}
				}
			}
			try {
				Thread.sleep(1000 * 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
