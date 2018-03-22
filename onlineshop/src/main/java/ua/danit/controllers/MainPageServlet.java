package ua.danit.controllers;

import ua.danit.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "mainServlet", urlPatterns = "/", loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {

    static Map<Long, Product> products = new HashMap<Long, Product>();

    static {
        products.put(1L, new Product(1L, "MacBook Pro", "", 200));
        products.put(2L, new Product(2L, "Algorithms, 4th Edition", "", 500));
        products.put(3L, new Product(3L, "Notebook Green", "", 100));
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getOutputStream().print(buildPage());
        response.getOutputStream().flush();
    }

    private String buildPage() {
        StringBuilder result = new StringBuilder();
        result.append("<html><body><ul>");
        for (Product p : products.values()) {
            result.append("<li>")
                    .append(p.getTitle())
                    .append("<form method='POST' action='/cart/products'>")
                    .append("<input type='hidden' name='productId' value='")
                    .append(p.getId())
                    .append("'/>")
                    .append("<button type='submit'>Add to Cart</button>")
                    .append("</form></li>");
        }
        if (!CartServlet.cart.isEmpty()) {
            result.append("<h3>Your cart</h3>");

            for (Product p: CartServlet.cart) {
                result.append("<div>").append(p.getTitle()).append("</div>");
            }
        }

        result.append("</ul></body></html>");
        return result.toString();
    }


}
