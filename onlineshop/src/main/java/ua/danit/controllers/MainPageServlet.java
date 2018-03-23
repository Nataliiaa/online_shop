package ua.danit.controllers;

import ua.danit.model.Product;
import ua.danit.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "mainServlet", urlPatterns = "/", loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {


    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print(buildPage());
        resp.getOutputStream().flush();
    }

    private String buildPage() {
        StringBuilder result = new StringBuilder();
        result.append("<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">")
                .append("<body>")
                .append("<h1>Products:</h1><ul>");

        products.values().forEach(e -> result
                .append("<li><a href='/product/?productId=")
                .append(e.getId())
                .append("'>")
                .append(e.getTitle())
                .append("</a>")
                .append("<form method='POST' action='/cart/products'>")
                .append("<input type='hidden' name='productId' value='")
                .append(e.getId())
                .append("'>")
                .append("<button type='submit'>Add to Cart</button>")
                .append("</form>")
                .append("</li>")
        );

        result.append("</ul>")
                .append("<a href='/cart/'>Cart Items:")
                .append(CartServlet.cart.size())
                .append("</a>")
                .append("</ul></body></html>");
        return result.toString();
    }
}
