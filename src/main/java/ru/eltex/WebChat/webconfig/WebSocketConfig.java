package ru.eltex.WebChat.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Класс {@code WebSocketConfig} включает и настройвает Stomp через WebSocket
 */
@Configuration

/** @EnableWebSocketMessageBroker включает обработку сообщений WebSocket,
 * поддерживаемую брокером(диспетчером очереди) сообщений
 * */
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Регистрирует конечную точку "/newMessage", включив протокол SockJS
     * */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/newMessage").withSockJS();
    }
}
