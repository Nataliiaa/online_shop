package ua.danit.service;

import ua.danit.dao.ProductDao;
import ua.danit.dao.ProductMockDaoImpl;
import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        List<Product> result = new ArrayList<>();
        Map<Category, List<Product>> productsByCategories = productDao.getAll();
        if(productsByCategories != null && productsByCategories.size() > 0){
            for (Map.Entry<Category, List<Product>> entry : productsByCategories.entrySet()) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    public Product getProductById(Long id){
        List<Product> products = getAllProducts();
        for (Product product : products) {
            if(id.equals(product.getId())){
                return product;
            }
        }
        return null;
    }

}
