package dasz.repository;

import dasz.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    Car findFirstByBrand(String brand);

    Car findFirstByPrice(double price);

    List<Car> findFirst3ByBrand(String brand);

    List<Car> findAllByBrandAndPrice(String brand, double price);

    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    List<Car> findAllByBrandLike(String pattern);

    List<Car> findAllByNameEndingWith(String pattern);

    List<Car> findAllByPriceLessThan(double price);

    List<Car> findAllByPriceBetween(double price1, double price2);

    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    List<Car> findAllByBrandNotNull();

    List<Car> findAllByNameIn(Collection<String> names);
}
