package dasz.dao;

import dasz.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long>{
}
