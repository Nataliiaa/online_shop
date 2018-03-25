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

import static ua.danit.service.ProductService.PRODUCT_SERVICE;
import static ua.danit.service.TemplateLoader.TEMPLATE_LOADER;

@WebServlet (name = "productPageServlet", urlPatterns = "/product")
public class ProductPageServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;
    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productService.getProductById(productId);
        PrintWriter out = resp.getWriter();
        templateLoader.write("product-page.ftl", out, ImmutableMap.of(
                "cartSize", CartServlet.getItemsCount(),
                "categories", Category.values(),
                "product", product
        ));
    }
}
