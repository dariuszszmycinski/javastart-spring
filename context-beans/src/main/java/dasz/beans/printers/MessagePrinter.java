package dasz.beans.printers;

import dasz.beans.producers.MessageProducer;
import dasz.beans.decorators.MessageDecorator;
import dasz.beans.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    private MessageProducer producer;
    private MessageDecorator decorator;

    @Autowired
    public MessagePrinter(@Producer(type = Producer.ProducerType.FILE) MessageProducer producer) {
        this.producer = producer;
    }

    public MessageDecorator getDecorator() {
        return decorator;
    }

    @Autowired(required = false)
    public void setDecorator(MessageDecorator decorator) {
        this.decorator = decorator;
    }

    public void print() {
        String message = producer.getMessage();
        message = decorator != null? decorator.decorate(message) : message;
        System.out.println(message);
    }
}