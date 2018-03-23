package ua.danit.controllers;

import ua.danit.model.Product;

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

    static Map<Long, Product> products = new HashMap<>();

    static {
        products.put(1L, new Product(
                1L,
                "MacBook Pro",
                "It's razor thin, feather light, and even faster and more powerful than before. It has the brightest, most colorful Mac notebook display ever. And it features the Touch Bar — a Multi-Touch enabled strip of glass built into the keyboard for instant access to the tools you want, right when you want them.",
                "https://brain-images-ssl.cdn.dixons.com/1/0/10165801/u_10165801.jpg",
                2000));
        products.put(2L, new Product(
                2L,
                "Asus Zenbook",
                "The feather-light 1.2kg ZenBook UX330 is a supremely elegant, 13.5mm-thin, all-metal laptop with up to 12 hours battery life.",
                "https://www.hardware-expert.nl/20084-thickbox_default/asus-zenbook-ux430ua-gv259t.jpg",
                1000));
        products.put(3L, new Product(3L,
                "GoF: Design Patterns",
                "Software engineering book describing software design patterns. The book's authors are Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.",
                "https://images-na.ssl-images-amazon.com/images/I/51szD9HC9pL._SX395_BO1,204,203,200_.jpg",
                10));
    }

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
