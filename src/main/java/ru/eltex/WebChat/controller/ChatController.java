package ru.eltex.WebChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.eltex.WebChat.ChatMessage;
import ru.eltex.WebChat.model.ChatMessageModel;
import ru.eltex.WebChat.repository.ChatMessageRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс {@code ChatController} описывает поведение приложения
 * @author Aleksey Gromov
 */

@Controller
public class ChatController {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @RequestMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

    private List<ChatMessageModel> chatMessageListBuilder() {
        Iterable<ChatMessageModel> chatMessageModelListIter = chatMessageRepository.findAll();
        List<ChatMessageModel> chatMessageModelList = new ArrayList<>();
        chatMessageModelListIter.forEach(chatMessageModelList::add);

        return chatMessageModelList;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public ChatMessage save(ChatMessageModel chatMessageModel) {
        ChatMessageModel chatMessage = new ChatMessageModel(chatMessageModel.getText(), chatMessageModel.getAuthor(), new Date());
        chatMessageRepository.save(chatMessage);

        List<ChatMessageModel> chatMessageModelList = chatMessageListBuilder();
        return new ChatMessage(chatMessageModelList.toString());
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public HttpEntity list() {
        List<ChatMessageModel> chatMessageModelList = chatMessageListBuilder();
        return new ResponseEntity(chatMessageModelList, HttpStatus.OK);
    }
}