package ua.danit.dao;

import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    Map<Category, List<Product>> getAll();
    List<Product> getByCategory(Category category);
    void add (Product product, Category category);
    void remove (Long productId);

}
