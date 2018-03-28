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
import static ua.danit.service.TemplateLoader.TEMPLATE_LOADER;

@WebServlet(name = "mainServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;
    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO: change when we implement authorization
        boolean isAdmin = "true".equals(req.getParameter("admin"));

        String category = req.getParameter("category");
        List<Product> products;
        String currentCategory;

        if (category == null) {
            products = productService.getAll();
            currentCategory = "All Products";
        } else {
            Category selectedCategory = Category.getCategoryByTitle(category);
            products = productService.getProductByCategory(selectedCategory);
            currentCategory = selectedCategory.getTitle();
        }

        PrintWriter out = resp.getWriter();
        templateLoader.write("main.ftl", out, ImmutableMap.builder()
                .put("cartSize", CartServlet.getItemsCount())
                .put("categories", Category.values())
                .put("products", products)
                .put("noProducts", products.isEmpty())
                .put("currentCategory", currentCategory)
                .put("isAdmin", isAdmin)
                .build()
        );
    }
}
