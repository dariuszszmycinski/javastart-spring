package dasz;

import dasz.model.Person;
import dasz.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.UnexpectedRollbackException;

@SpringBootApplication
public class SpringValidationJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidationJpaApplication.class, args);
        Person person = new Person("Jan", null, "złyEmail", 0);
        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        try {
            personRepository.add(person);
        } catch(TransactionSystemException | UnexpectedRollbackException e) {
            System.err.println(e.getMessage());
        }

        ctx.close();
    }

}
