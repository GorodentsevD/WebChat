package ru.eltex.WebChat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Message {
    @NonNull private String message;
}