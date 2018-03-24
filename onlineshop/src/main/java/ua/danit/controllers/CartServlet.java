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

@WebServlet (name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    public static Map<Product, Integer> cart = new HashMap<>();
    public static int cartTotal = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainPageServlet mainPageServlet = new MainPageServlet();
        mainPageServlet.setupHeaderAttributes(req);
        setupCartAttributes(req);
        req.getRequestDispatcher("WEB-INF/views/cart.ftl").forward(req, resp);
    }

    private void setupCartAttributes(HttpServletRequest req) {
        req.setAttribute("emptyCart", cart.isEmpty());
        req.setAttribute("cart", cart.entrySet());
        req.setAttribute("cartTotal", cartTotal);
    }

    public static void addToCart(Product product) {
        Integer productCount = CartServlet.cart.getOrDefault(product, 0);
        cart.put(product, ++productCount);
        cartTotal += product.getPrice();
    }

    public static void removeProductFromCart(Product product) {
        Integer productCount = CartServlet.cart.getOrDefault(product, 0);
        if (productCount > 0) {
            cartTotal -= product.getPrice() * productCount;
            CartServlet.cart.remove(product);
        }
    }

    public static void removeAllFromCart() {
        CartServlet.cart = new HashMap<>();
        cartTotal = 0;
    }
}
