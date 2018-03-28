package ua.danit.controllers;

import ua.danit.model.Product;
import ua.danit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet (urlPatterns = "/comment/action/*")
public class CommentActionServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if (Actions.ADD.action.equals(action)) {
            Long productId = Long.parseLong(req.getParameter("productId"));
            String text = req.getParameter("commentText");
            String author = req.getParameter("commentAuthor");
            int rating = Integer.parseInt(req.getParameter("commentRating"));

            Product product = productService.getProductById(productId);
            product.addComment(text, author, rating);

            resp.sendRedirect("/product?productId=" + productId);
        }
    }

    //TODO: need to remove
    private enum Actions {
        ADD("/add");

        private String action;

        Actions (String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }
}
