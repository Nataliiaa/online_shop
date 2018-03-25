package ua.danit.service;

import ua.danit.controllers.CartServlet;
import ua.danit.dao.ProductDao;
import ua.danit.dao.ProductMockDaoImpl;
import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.*;

public class ProductService {

    public static final ProductService PRODUCT_SERVICE = new ProductService();

    private ProductService(){

    }

    private ProductDao productDao = new ProductMockDaoImpl();

    public Map<Category, List<Product>> getProductsByCategories(){
        return productDao.getAll();
    }

    public List<Product> getProductByCategory(Category category) {
        return productDao.getByCategory(category);
    }

    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    public Product getProductById(Long id){
        return productDao.getProductById(id);
    }

    public void add(Product product, Category category) {
        productDao.add(product, category);
    }

    public void remove(Long id) {
        Product product = productDao.getProductById(id);
        CartServlet.removeProductFromCart(product);
        productDao.remove(id);
    }

}
