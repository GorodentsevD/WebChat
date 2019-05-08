package ru.eltex.WebChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Класс {@code Message} формирует сообщение, которое будет отправлено
 */

@Data
@AllArgsConstructor
public class Message {
    @NonNull private String message;
}