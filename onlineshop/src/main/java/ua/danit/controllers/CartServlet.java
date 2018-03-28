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

import static ua.danit.service.TemplateLoader.TEMPLATE_LOADER;

@WebServlet (name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    // TODO merge CartServlet & CartActionServlet. They are using the same methods.
    public static Map<Product, Integer> cart = new HashMap<>();
    public static int cartTotalPrice = 0;

    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        templateLoader.write("cart.ftl", out, ImmutableMap.of(
                "cartSize", getItemsCount(),
                "categories", Category.values(),
                "emptyCart", cart.isEmpty(),
                "cart", cart.entrySet(),
                "cartTotalPrice", cartTotalPrice
        ));
    }

    public static int getItemsCount() {
        return cart.values().stream().mapToInt(integer -> integer.intValue()).sum();
    }

    public static void addToCart(Product product) {
        Integer productCount = CartServlet.cart.getOrDefault(product, 0);
        cart.put(product, ++productCount);
        cartTotalPrice += product.getPrice();
    }

    public static void removeProductFromCart(Product product) {
        Integer productCount = CartServlet.cart.getOrDefault(product, 0);
        if (productCount > 0) {
            cartTotalPrice -= product.getPrice() * productCount;
            CartServlet.cart.remove(product);
        }
    }

    public static void removeAllFromCart() {
        CartServlet.cart = new HashMap<>();
        cartTotalPrice = 0;
    }
}
