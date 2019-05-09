package ru.eltex.WebChat.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Класс WebSocketConfig включает и настройвает Stomp через WebSocket
 */
@Configuration
/*Включает обработке сообщений по WebSocket, возвращаемый брокером сообщений*/
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Переопределяет поведение по умолчанию в WebSocketMessageBrokerConfigurer для настройки брокера сообщений.
     * Он вызывает enableSimpleBroker() для включения простого брокера сообщений в памяти чтобы возвращать обратно
     * сообщения клиенту по направлениям с префиксом /topic. Он также объявляет префикс /app для сообщений,
     * привязанных к методам, аннотированными @MessageMapping
     * */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Регистрирует /newMessage, включая дополнительно SockJS как альтернативный вариант обмена сообщениями,
     * когда WebSocket не доступен.
     * */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/newMessage").withSockJS();
    }
}
