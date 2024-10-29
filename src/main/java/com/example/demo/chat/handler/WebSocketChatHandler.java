package com.example.demo.chat.handler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketChatHandler extends TextWebSocketHandler{
	// 클라이언트가 발송한 메시지 받아서 치리해줄 Handler
	
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	/*
	 * 클라이언트는 서버에 접속하면 개별 WebSocketSession를 갖는다
	 * 클라이언트 ~ WebSocketSession
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		sessions.add(session);
		
		String payload = message.getPayload();
		log.info("payload {}",payload); // client에게 받은 메시지 log에 출력

		TextMessage textMessage = new TextMessage(payload);

		for (WebSocketSession ss : sessions) {
			ss.sendMessage(textMessage);
		}
//		session.sendMessage(textMessage); // client에게 메시지 보내기
	}
}
