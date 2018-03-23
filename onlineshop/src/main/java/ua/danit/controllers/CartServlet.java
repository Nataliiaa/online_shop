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

@WebServlet (name = "cartServlet", urlPatterns = "/cart/")
public class CartServlet extends HttpServlet {

    public static List<Product> cart = new ArrayList<>();

    private String buildCartContentsPage() {
        StringBuilder result = new StringBuilder();
        result.append("<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">")
                .append("<body>")
                .append("<h1>Cart:</h1>")
                .append("<ul>");

        //TODO: move total to another page
        int totalCost = 0;

        if (cart.isEmpty()) {
            result.append("<p>Cart is empty</p>");
        } else {
            for (Product product : cart) {
                result.append("<li><a href='/product/?productId=")
                        .append(product.getId())
                        .append("'>")
                        .append(product.getTitle())
                        .append("</a>")
                        .append("</li>");
                totalCost += product.getPrice();
            }
        }

        result.append("</ul><p>")
                .append("<p>Total cost: $")
                .append(totalCost)
                .append("</p><p><form action='/cart/order/'><button type='submit'>Buy Now</button></form></p>")
                .append("<p><a href='/'>&lt; home page</a></p></body></html>");
        return result.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print(buildCartContentsPage());
        resp.getOutputStream().flush();
    }
}
