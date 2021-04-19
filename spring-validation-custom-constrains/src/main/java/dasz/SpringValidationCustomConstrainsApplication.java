package dasz;

import dasz.model.Message;
import dasz.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class SpringValidationCustomConstrainsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidationCustomConstrainsApplication.class, args);
        MessageService msqService = ctx.getBean(MessageService.class);
        Message msg = new Message("Hello message", "Cholercia to brzydkie słowo");
        boolean verifyMessage = msqService.verifyMessage(msg);
        System.out.println("Wiadomość poprawna? "+verifyMessage);
        ctx.close();
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
