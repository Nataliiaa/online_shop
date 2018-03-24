package ua.danit.controllers;

import com.google.common.collect.ImmutableMap;
import ua.danit.model.Category;
import ua.danit.model.Product;
import ua.danit.service.TemplateLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet (name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    public static Map<Product, Integer> cart = new HashMap<>();
    public static int cartTotal = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TemplateLoader templateLoader = new TemplateLoader();
        templateLoader.write("cart.ftl", out, ImmutableMap.of(
                "cartSize", getItemsCount(),
                "categories", Category.values(),
                "emptyCart", cart.isEmpty(),
                "cart", cart.entrySet(),
                "cartTotal", cartTotal
        ));
    }

    public static int getItemsCount() {
        return cart.values().stream().mapToInt(integer -> integer.intValue()).sum();
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
