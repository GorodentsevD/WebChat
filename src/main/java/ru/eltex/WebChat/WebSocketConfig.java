package ru.eltex.WebChat;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Класс {@code WebSocketConfig }
 *
 * @author Aleksey Gromov
 * */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //private static Logger logger = Logger.getLogger(WebSocketConfig.class.getSimpleName());

    /**
     * Регестрирует конечную точку, которую будут использовать клиенты для подключения к WebSocket серверу
     * */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //logger.info("endPoint registered");
        registry.addEndpoint("/ws").withSockJS();
    }

    /**
     * Брокер сообщений, который будет использоваться для направления сообщений от одного клиента к другому
     * */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * Сообщения, чей адрес (куда отправлены) начинается с  “/app“, должны быть направлены в методы,
         * занимающиеся обработкой сообщений
         * */
        registry.setApplicationDestinationPrefixes("/app");

        /**
         * Сообщения, чей адрес начинается с  “/topic“, должны быть направлены в брокер сообщений.
         * Брокер перенаправляет сообщения всем клиентам, подписанным на тему
         * */
        registry.enableSimpleBroker("/topic");
    }
}