package dasz;

import dasz.model.NumberBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class SpringValidatorMessagesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorMessagesApplication.class, args);
        //Locale.setDefault(Locale.GERMAN);
        Validator validator = ctx.getBean(Validator.class);
        NumberBean numberBean= new NumberBean(2);
        Set<ConstraintViolation<NumberBean>> errors = validator.validate(numberBean);
        errors.forEach(err -> System.out.println(err.getMessage()));
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
