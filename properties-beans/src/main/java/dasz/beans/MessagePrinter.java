package dasz.beans;

import org.springframework.beans.factory.annotation.Autowired;

import dasz.beans.Message.MessageType;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    @Message(type = MessageType.FILE)
    private MessageProducer producer;

    public void print() {
        System.out.println("Message produced: " + producer.getMessage());
    }
}
