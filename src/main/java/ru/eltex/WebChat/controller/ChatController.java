package ru.eltex.WebChat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс {@code ChatController} описывает поведение приложения
 * @author Aleksey Gromov
 */

@Controller
public class ChatController {
    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}
