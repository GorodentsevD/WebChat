package ru.eltex.WebChat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eltex.WebChat.model.ChatMessageModel;

import java.util.List;

/**
 * Класс ChatMessageRepository репозиторий для работы с сущностью(сообщением)
 */

public interface ChatMessageRepository extends CrudRepository<ChatMessageModel, Integer> {
    @Override
    List<ChatMessageModel> findAll();
}
