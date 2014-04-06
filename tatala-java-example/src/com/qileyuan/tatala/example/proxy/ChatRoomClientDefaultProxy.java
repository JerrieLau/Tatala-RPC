package com.qileyuan.tatala.example.proxy;

import com.qileyuan.tatala.example.client.ChatRoomClient;
import com.qileyuan.tatala.proxy.DefaultProxy;
import com.qileyuan.tatala.socket.to.StandardTransferObject;
import com.qileyuan.tatala.socket.to.TransferObject;

public class ChatRoomClientDefaultProxy extends DefaultProxy {
	
	public Object execute(TransferObject abstractto){
		StandardTransferObject to = (StandardTransferObject)abstractto;
		String calleeMethod = to.getCalleeMethod();
		if(calleeMethod.equals("receiveMessage")){
			String message = to.getString("message");
			ChatRoomClient.getInstance().receiveMessage(message);
		}
		return null;
	}
}
