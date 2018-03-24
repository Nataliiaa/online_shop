package ua.danit.dao;

import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.*;

public class ProductMockDaoImpl implements ProductDao {

    private Map<Category, List<Product>> products = new HashMap<>();


    public ProductMockDaoImpl(Map<Category, List<Product>> products) {
        products.put(Category.Mobile, Arrays.asList(new Product(1L, "IphoneX", "","",1000),
                new Product(2L, "Iphone5", "","",1000),
                new Product(3L, "Iphone6", "","",1000),
                new Product(4L, "Iphone7", "","",1000)
                ));

        products.put(Category.Computer, Arrays.asList(new Product(5L, "MacBook Pro", "","",2000),
                new Product(6L, "Asus Zenbook", "","",1000)
        ));

        products.put(Category.Book, Collections.singletonList(new Product(7L, "GoF: Design Patterns", "", "", 10)));
    }


    @Override
    public Map<Category, List<Product>> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        if(category == null){
            System.out.println("Empty category for getProducts");
            return new ArrayList<>();
        }
        return products.get(category);
    }

}
