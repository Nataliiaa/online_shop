package ua.danit.service;

import ua.danit.controllers.CartServlet;
import ua.danit.dao.ProductDao;
import ua.danit.dao.ProductMockDaoImpl;
import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    public static final ProductService PRODUCT_SERVICE = new ProductService();

    private ProductService(){
    }

    private ProductDao productDao = new ProductMockDaoImpl();


    public List<Product> getProductByCategory(Category category) {
        return productDao.getByCategory(category);
    }

    public List<Product> getAll(){
        return productDao.getAll();
    }

    public Product getProductById(Long id){
        return productDao.getProductById(id);
    }

    public void add(Product product) {
        productDao.add(product);
    }

    public void remove(Long id) {
        productDao.remove(id);
    }

    public List<Product> getProductsByTitle(String searchPhrase) {
        return productDao.getAll().stream()
                .filter(e -> e.getTitle().toLowerCase().startsWith(searchPhrase.toLowerCase()))
                .collect(Collectors.toList());
    }

}
