package ua.danit.controllers;

import com.google.common.collect.ImmutableMap;
import ua.danit.model.Category;
import ua.danit.model.Product;
import ua.danit.service.ProductService;
import ua.danit.service.TemplateLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet(name = "mainServlet", urlPatterns = "/", loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        PrintWriter out = resp.getWriter();
        TemplateLoader templateLoader = new TemplateLoader();
        templateLoader.write("products.ftl", out, ImmutableMap.of(
                "cartSize", CartServlet.getItemsCount(),
                "categories", Category.values(),
                "products", products,
                "currentCategory", currentCategory
        ));
    }
}
