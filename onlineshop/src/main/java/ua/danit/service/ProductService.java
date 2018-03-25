package ua.danit.service;

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

    public void add(Product product, Category category) {
        productDao.add(product, category);
    }

    public void remove(Long id) {
        //productDao.getAll().values().removeIf(val -> getProductById(id).equals(val));
        //productDao.getAll().values().removeAll(Collections.singleton(getProductById(id)));
        //productDao.remove(id);

        Map<Category, List<Product>> allProducts = getProductsByCategories();
        Product product = getProductById(id);

        allProducts.forEach(
                (Category k, List<Product> v) -> v.removeAll(
                        Collections.singleton(product)
                )
        );

    }

}
