package dasz;

import dasz.dao.ProductDao;
import dasz.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaProductApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaProductApplication.class, args);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Telewizor", "Samsung", 4500.0));
        products.add(new Product("Opiekacz", "Opiex", 120.0));
        products.add(new Product("Laptop", "Samsung", 3599.0));
        products.add(new Product("Kino domowe", "Yamaha", 2600.0));
        products.add(new Product("Smartfon", "Sony", 2100.0));

        ProductDao productDao = ctx.getBean(ProductDao.class);
        products.forEach(productDao::save);

        System.out.println("All products:");
        List<Product> allProducts = productDao.getAll();
        allProducts.forEach(System.out::println);

        System.out.println("Products more expensive than 3000");
        List<Product> expensiveProducts = productDao.customGet("SELECT p FROM Product p WHERE p.price > 3000");
        expensiveProducts.forEach(System.out::println);

        System.out.println("All products ordered by price");
        List<Product> productsByPrice = productDao.customGet("SELECT p FROM Product p ORDER BY p.price ASC");
        productsByPrice.forEach(System.out::println);

        System.out.println("Expensive Samsung Products:");
        List<Product> expensiveSamsungProducts = productDao.customGet("SELECT p FROM Product p WHERE p.producer = 'Samsung' AND p.price > 4000");
        expensiveSamsungProducts.forEach(System.out::println);

        productDao.deleteByProducer("Samsung");
        System.out.println("Products without Samsung:");
        productDao.getAll().forEach(System.out::println);

        System.out.println("Opiekacze:");
        List<Product> productByName = productDao.getByName("Opiekacz");
        System.out.println(productByName);

        productDao.deleteAll();

        ctx.close();
    }

}
