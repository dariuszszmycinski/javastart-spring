package dasz;

import dasz.dao.UserDao;
import dasz.dao.UserDetailsDao;
import dasz.model.User;
import dasz.model.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);

        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("johnny234", "strongPass","johnny@gmail.com");
        UserDetails details = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setDetails(details);
        userDao.save(user);

        UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
        UserDetails getUserDetails = userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());

        ctx.close();
    }
}
