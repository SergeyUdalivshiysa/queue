package ru.volegov.messagequeue.exeption;

import org.springframework.stereotype.Component;
import ru.volegov.messagequeue.entities.Message;

import java.util.List;
import java.util.function.Predicate;

@Component
public class MessageExceptionThrower {
    public void trowNoElementsException(Predicate<Object> p, Object o) {
        if (p.test(o)) {
            throw new NoElementsException("There are no elements...");
        }
    }

    public void throwNoElementExceptionOnNullMessage(Message message) {
        if (message == null) {
            throw new NoElementsException("There are no elements...");
        }
    }

    public void throwNoElementsInEmptyList(List<?> list) {
        if (list.isEmpty()) {
            throw new NoElementsException("There are no elements...");
        }
    }
}
