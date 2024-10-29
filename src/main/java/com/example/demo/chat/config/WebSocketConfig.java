package com.example.demo.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket // WebSocket 활성화
public class WebSocketConfig implements WebSocketConfigurer{
	
	private final WebSocketHandler webSocketHandler; // WebSocketChatHandler extends TextWebSocketHandler 쭉 타고가면 WebSocketHandler 있음
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
		
	}

	
}
