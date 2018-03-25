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
import java.util.List;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;
import static ua.danit.service.TemplateLoader.TEMPLATE_LOADER;

@WebServlet (urlPatterns = {"/admin"}, name = "adminServlet")
public class AdminServlet extends HttpServlet{

    private final ProductService productService = PRODUCT_SERVICE;
    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        PrintWriter out = resp.getWriter();
        templateLoader.write("admin.ftl", out, ImmutableMap.of(
                "cartSize", CartServlet.getItemsCount(),
                "categories", Category.values(),
                "products", products
        ));
    }
}
