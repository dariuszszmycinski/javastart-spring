package dasz;

import javax.validation.Validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import dasz.model.Person;
import dasz.service.PersonService;

@Configuration
@ComponentScan
public class SpringValidationBvApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringValidationBvApplication.class);

        PersonService personService = ctx.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        System.out.println("Adding " + person1);
        personService.addPerson(person1); //ok

        Person person2 = new Person("Anna", null, "zlyEmail", 0);
        System.out.println("Adding " + person2);
        personService.addPerson(person2); //not ok

        System.out.println("People size " + personService.getPeople().size());
        for(Person p: personService.getPeople()) {
            System.out.println(p);
        }

        ctx.close();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}