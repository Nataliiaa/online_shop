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

@WebServlet(urlPatterns = "/admin/action/*", name = "adminActionServlet")
public class AdminActionServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;
    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if (Actions.REMOVE.action.equals(action)) {
            Long productId = Long.parseLong(req.getParameter("productId"));
            productService.remove(productId);
        }

        if (Actions.ADD.action.equals(action)) {
            String title = req.getParameter("productTitle");
            String description = req.getParameter("productDescription");
            String imageUrl = req.getParameter("productImageUrl");
            String productPrice = req.getParameter("productPrice");
            int price = (productPrice.isEmpty()) ? 0 : Integer.parseInt(productPrice);
            Category category = Category.valueOf(req.getParameter("productCategory"));

            productService.add(new Product(title, description, imageUrl, price), category);
        }

        resp.sendRedirect("/admin");
    }

    private enum Actions {
        ADD("/add"), REMOVE("/remove");

        private String action;

        Actions(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }
}
