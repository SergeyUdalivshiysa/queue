package ru.volegov.messagequeue.controller;

import org.springframework.web.bind.annotation.*;
import ru.volegov.messagequeue.exeption.MessageExceptionThrower;
import ru.volegov.messagequeue.entities.Message;
import ru.volegov.messagequeue.service.MessageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/messages")
public class Controller {

    MessageService messageService;

    MessageExceptionThrower messageExceptionThrower;

    public Controller(MessageService messageService, MessageExceptionThrower messageExceptionThrower) {
        this.messageService = messageService;
        this.messageExceptionThrower = messageExceptionThrower;
    }

    @PostMapping
    public void offer(@Valid @RequestBody Message message) {
        messageService.offer(message);
    }

    @GetMapping("/peek")
    public Message peek() {
        Message message = messageService.peek();
        messageExceptionThrower.throwNoElementExceptionOnNullMessage(message);
        return message;
    }

    @DeleteMapping("/poll")
    public Message poll() {
        Message message = messageService.poll();
        messageExceptionThrower.throwNoElementExceptionOnNullMessage(message);
        return message;
    }

    @GetMapping("/peekmax")
    public Message peekMax() {
        Message message = messageService.peekMax();
        messageExceptionThrower.throwNoElementExceptionOnNullMessage(message);
        return message;
    }

    @GetMapping("/")
    public List<Message> getAll() {
        List<Message> messages = messageService.getAll();
        messageExceptionThrower.throwNoElementsInEmptyList(messages);
        return messages;
    }


}
