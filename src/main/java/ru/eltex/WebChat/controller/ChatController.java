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
import ru.eltex.WebChat.Message;
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

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public Message save(ChatMessageModel chatMessageModel) {
        ChatMessageModel chatMessage = new ChatMessageModel(chatMessageModel.getText(), chatMessageModel.getAuthor(), new Date());
        chatMessageRepository.save(chatMessage);
        /*TODO вынести в отдельную функцию или найти метод который возвращает список вместо итераторов например PagingAndSortingRepository*/
        Iterable<ChatMessageModel> chatMessageModelListIter = chatMessageRepository.findAll();
        List<ChatMessageModel> chatMessageModelList = new ArrayList<>();
        chatMessageModelListIter.forEach(chatMessageModelList::add);
        return new Message(chatMessageModelList.toString());
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public HttpEntity list() {
        Iterable<ChatMessageModel> chatMessageModelListIter = chatMessageRepository.findAll();
        /*TODO вынести в отдельную функцию или найти метод который возвращает список вместо итераторов*/
        List<ChatMessageModel> chatMessageModelList = new ArrayList<>();
        chatMessageModelListIter.forEach(chatMessageModelList::add);
        return new ResponseEntity(chatMessageModelList, HttpStatus.OK);
    }
}