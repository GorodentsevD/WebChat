package ru.eltex.WebChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.eltex.WebChat.Message;
import ru.eltex.WebChat.model.ChatMessageModel;
import ru.eltex.WebChat.repository.ChatMessageRepository;
import java.util.Date;
import java.util.List;

/**
 * Класс {@code ChatController} описывает поведение приложения
 * @author Aleksey Gromov
 */

@Controller
public class  ChatController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @PostMapping("/messages")
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public Message save(@Payload ChatMessageModel chatMessageModel) {
        ChatMessageModel chatMessage = new ChatMessageModel(chatMessageModel.getText(),
                chatMessageModel.getAuthor(), new Date(), chatMessageModel.getType());
        chatMessageRepository.save(chatMessage);
        return new Message(chatMessage.toString());
    }

    @GetMapping("/messages")
    public HttpEntity<List<ChatMessageModel>> list() {
        List<ChatMessageModel> chatMessageModelList = chatMessageRepository.findAll();
        return new ResponseEntity<>(chatMessageModelList, HttpStatus.OK);
    }
}