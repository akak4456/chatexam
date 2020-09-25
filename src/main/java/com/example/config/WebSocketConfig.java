package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		/*Register STOMP endpoints mapping each to a specific URL and 
		(optionally) enabling and configuring SockJS fallback options.
		SockJS는 웹소켓을 지원하지 않는 브라우저에 폴백 옵션을 활성화 하는데 사용됨
		Fallback이란? 어떤 기능이 약해지거나 제대로 동작하지 않을 때, 이에 대처하는 기능 또는 동작
		STOMP Simple Text Oriented Messaging Protocol의 약자:데이터 교환 규정*/
		registry.addEndpoint("/ws").withSockJS();
	}
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		/*
		 Configure the message converters to use when extracting the payload of messages in 
		 annotated methods and when sending messages (e.g. through the "broker" SimpMessagingTemplate).
		한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는 데 사용될 메시지 브로커를 구성함
		 */
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}
}
