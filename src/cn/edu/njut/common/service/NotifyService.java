package cn.edu.njut.common.service;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;

public class NotifyService {
	private static int accessId = 2100012276;
	private static String secretKey = "2e16f9ebb4c5403262571ed1effdddc6";
	private static XingeApp xinge = new XingeApp(accessId, secretKey);
	private static int expireTime = 60 * 60 * 2;
	private static int type = 2;	// transparent orders
	
	/**
	 *  Transparent orders - all actions depends on the convention among server and clients
	 */
	
	public static boolean pushSingleAccount(String account, String title, String content) {
		Map custom = new HashMap();
		String timestamp = DateFormat.getDateTimeInstance().format(new Date());
		custom.put("order", "1");
		custom.put("timestamp", timestamp);
		Message message = new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setExpireTime(expireTime);
		message.setType(type);
		message.setCustom(custom);
		JSONObject json = xinge.pushSingleAccount(0, account, message); 	// deviceType-0 means 'no limit'
		int ret_code = json.getInt("ret_code");
		if(ret_code == 0)	// success
			return true;
		return false;
	}
	public static void main(String[] args) {
		//pushSingleAccount("1405110111", "推送消息", "教师端测试！");
		/*
		int accessId = 2100012276;
		String secretKey = "2e16f9ebb4c5403262571ed1effdddc6";
		XingeApp xinge = new XingeApp(accessId, secretKey);
		int deviceType = 0;
		String account = "1405110111";
		String title = "新消息";
		String content = "Android推送测试";
		int expireTime = 60 * 60 * 12;
		int type = 1;
		Style style = new Style(0, 1, 1, 1, 0);
		ClickAction clickAction = new ClickAction();
		clickAction.setActionType(1);
		Message message = new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setExpireTime(expireTime);
		message.setType(type);
		message.setStyle(style);
		message.setAction(clickAction);
		String result = xinge.pushSingleAccount(deviceType, account, message).toString();
		System.out.println(result);
		*/
	}
}
