package ru.volegov.messagequeue.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ru.volegov.messagequeue.entities.Message;
import ru.volegov.messagequeue.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void offer(@RequestBody Message message) {
        messageRepository.save(message);
    }

    public Message peek() {
        Message message = messageRepository.findFirst();
        return message;
    }

    @Transactional
    public Message poll() {
        Message message = messageRepository.findFirst();

        messageRepository.deleteById(message.getId());
        return message;
    }

    public Message peekMax() {
        return messageRepository.findLast();
    }

    public List<Message> getAll() {
        return messageRepository.findAll(Sort.by("id").ascending());

    }
}
