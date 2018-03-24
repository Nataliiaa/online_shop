package ua.danit.controllers;

import ua.danit.model.Product;
import ua.danit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet(name = "cartActions", urlPatterns = "/cart/action/*")
public class CartActionServlet extends HttpServlet {

    private final ProductService productService = PRODUCT_SERVICE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        Long productId = Long.valueOf(req.getParameter("productId"));

        Product product = productService.getProductById(productId);

        if(Actions.ADD.getAction().equals(action)){
            CartServlet.cart.add(product);
        }
        resp.sendRedirect("/");
    }


    private enum Actions{
        ADD("/add"), REMOVE("/remove");
        Actions(String action) {
            this.action = action;
        }
        private String action;
        public String getAction() {
            return action;
        }
    }
}
