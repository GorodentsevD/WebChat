package ru.eltex.WebChat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.eltex.WebChat.model.ChatMessageModel;

import java.util.List;

/**
 * Класс {@code ChatMessageRepository} репозиторий
 * @author Aleksey Gromov
 */

public interface ChatMessageRepository extends CrudRepository<ChatMessageModel, Integer> {}
