package ua.danit.controllers;

import ua.danit.model.Category;
import ua.danit.model.Product;
import ua.danit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet(name = "mainServlet", urlPatterns = "/", loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setupHeaderAttributes(req);
        setupMainPageAttributes(req);
        req.getRequestDispatcher("WEB-INF/views/products.ftl").forward(req, resp);
    }

    private void setupMainPageAttributes(HttpServletRequest req) {
        String category = req.getParameter("category");
        List<Product> products;
        String currentCategory;

        if (category == null) {
            products = productService.getAllProducts();
            currentCategory = "All Products";
        } else {
            products = productService.getProductByCategory(Category.valueOf(category));
            currentCategory = Category.valueOf(category).getTitle();
        }

        req.setAttribute("products", products);
        req.setAttribute("currentCategory", currentCategory);
    }

    public void setupHeaderAttributes(HttpServletRequest req) {
        int cartSize = CartServlet.cart.size();
        req.setAttribute("cartSize", cartSize);
        Category[] categories = Category.values();
        req.setAttribute("categories", categories);
    }
}
