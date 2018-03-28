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

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

//TODO: concatanate these servlets into one ProductServlet
@WebServlet (urlPatterns = "/product/action/*", name = "productsActionServlet")
public class ProductsActionServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if (Actions.REMOVE.getAction().equals(action)) {
            Long productId = Long.parseLong(req.getParameter("productId"));
            Product product = productService.getProductById(productId);
            CartServlet.removeProductFromCart(product);
            productService.remove(productId);
        }

        if (Actions.ADD.getAction().equals(action)) {
            String title = req.getParameter("productTitle");
            String description = req.getParameter("productDescription");
            String imageUrl = req.getParameter("productImageUrl");
            int price = 0;

            try {
                price = Integer.parseInt(req.getParameter("productPrice"));
            } catch (NumberFormatException e) {
                String errorMessage = "Product Price must be a valid number";
                resp.sendError(400, errorMessage);
            }

            Category category = Category.getCategoryByTitle(req.getParameter("productCategory"));
            productService.add(new Product(title, category, description, imageUrl, price));
        }

        resp.sendRedirect("/?admin=true");
    }
}
