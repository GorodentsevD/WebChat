package ru.eltex.WebChat.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Класс Message формирует сообщение, которое будет отправлено
 */
@Data
@AllArgsConstructor
public class Message {

    /** Сформированное сообщение */
    @NonNull private String message;
}