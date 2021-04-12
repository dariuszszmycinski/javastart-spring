package dasz;

import dasz.dao.BookDao;
import dasz.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaApplication.class, args);

        // CREATE
        BookDao dao = ctx.getBean(BookDao.class);
        Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
        Book book1 = new Book("1234567890469", "Spring sometimes hard", "Javastart");
        dao.save(book);
        dao.save(book1);

        // UPDATE
        Book book2 = new Book("987654321", "Spring is NOT so cool", "Javastart");
        book2.setId(1L);
        dao.update(book2);

        // READ
        Book findBook = dao.get(1L);
        System.out.println(findBook);

        // DELETE
        dao.remove(1L);
        Book book3 = dao.get(2L);
        System.out.println(book3); //null
    }
}
