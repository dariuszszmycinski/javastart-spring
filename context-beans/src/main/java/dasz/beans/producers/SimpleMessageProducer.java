package dasz.beans.producers;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Producer(type = Producer.ProducerType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {


    @Override
    public String getMessage() {
        return "Simple Message: " +  new Random().nextInt();
    }
}
