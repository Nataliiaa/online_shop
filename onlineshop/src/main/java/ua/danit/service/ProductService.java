package ua.danit.service;

import ua.danit.dao.ProductDao;
import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductDao productDao;

    public Map<Category, List<Product>> getAllProducts(){
        return productDao.getAllProducts();
    }
}
