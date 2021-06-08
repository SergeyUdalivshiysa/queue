package ru.volegov.messagequeue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.volegov.messagequeue.entities.Message;
import ru.volegov.messagequeue.utils.DatabaseInit;

@SpringBootApplication
public class MessagequeueApplication {



    public static void main(String[] args) {
        SpringApplication.run(MessagequeueApplication.class, args);

    }

}
