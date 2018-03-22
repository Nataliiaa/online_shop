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

@WebServlet (urlPatterns = "/cart/")
public class CartServlet extends HttpServlet {

    public static List<Product> cart = new ArrayList<>();

    private String getCartContents() {
        StringBuilder result = new StringBuilder();
        result.append("<html><body>")
                .append("<h1>Cart:</h1>")
                .append("<ul>");

        for(Product product : cart) {
            result.append("<li>");
            result.append(product.getTitle());
            result.append("</li>");
        }

        result.append("</ul><p><form action='/cart/order/'><button type='submit'>Buy Now</button></form></p>")
                .append("<p><a href='/'>&lt; home page</a></p></body></html>");
        return result.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print(getCartContents());
        resp.getOutputStream().flush();
    }
}
