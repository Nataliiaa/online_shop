package ua.danit.controllers;

import ua.danit.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartServlet", urlPatterns = "/cart/products")
public class CartServlet extends HttpServlet {

    public static List<Product> cart = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.valueOf(req.getParameter("productId"));
        Product p = MainPageServlet.products.get(productId);

        if (p != null) {
            cart.add(p);
        }
        resp.sendRedirect("/");
    }
}
