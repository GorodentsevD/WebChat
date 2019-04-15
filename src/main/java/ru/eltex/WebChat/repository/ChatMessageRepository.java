package ru.eltex.WebChat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eltex.WebChat.model.ChatMessageModel;

public interface ChatMessageRepository extends CrudRepository<ChatMessageModel, Integer> {

}
