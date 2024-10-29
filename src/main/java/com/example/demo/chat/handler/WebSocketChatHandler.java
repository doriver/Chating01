package com.example.demo.chat.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketChatHandler extends TextWebSocketHandler{
	// 클라이언트가 발송한 메시지 받아서 치리해줄 Handler
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload {}",payload); // client에게 받은 메시지 log에 출력
		TextMessage textMessage = new TextMessage("Welcome chatting server");
		session.sendMessage(textMessage); // client에게 환영 메시지 보내기
	}
}
