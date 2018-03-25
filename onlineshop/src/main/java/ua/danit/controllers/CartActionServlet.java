package ua.danit.controllers;

import ua.danit.model.Product;
import ua.danit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet(name = "cartActions", urlPatterns = "/cart/action/*")
public class CartActionServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();

        if (Actions.ADD.getAction().equals(action)) {
            Product product = getProductId(req);
            CartServlet.addToCart(product);
        }

        if (Actions.REMOVE.getAction().equals(action)) {
            Product product = getProductId(req);
            CartServlet.removeProductFromCart(product);
        }

        if (Actions.REMOVEALL.getAction().equals(action)) {
            CartServlet.removeAllFromCart();
        }

        if (Actions.ORDER.getAction().equals(action)) {
            CartServlet.removeAllFromCart();
        }

        String referer = req.getHeader("Referer");

        if (referer != null && !referer.isEmpty()) {
            resp.sendRedirect(referer);
        } else {
            resp.sendRedirect("/cart");
        }
    }

    private Product getProductId(HttpServletRequest req) {
        Long productId = Long.valueOf(req.getParameter("productId"));
        return productService.getProductById(productId);
    }


    private enum Actions {
        ADD("/add"), REMOVE("/remove"), REMOVEALL("/removeall"), ORDER("/order");

        Actions(String action) {
            this.action = action;
        }

        private String action;

        public String getAction() {
            return action;
        }
    }
}
