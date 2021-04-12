package dasz.main;

import dasz.dao.BookDao;
import dasz.dao.BookDaoImpl;
import dasz.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("123456789", "Wilk z Wall Street", "Jordan Belfort");
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved");
        Book book1 = bookDao.get(1L);
        System.out.println(book1);
        bookDao.cleanUp();
    }
}
