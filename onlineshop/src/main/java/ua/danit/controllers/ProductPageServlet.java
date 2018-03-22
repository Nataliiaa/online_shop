package ua.danit.controllers;

import ua.danit.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/product/")
public class ProductPageServlet extends HttpServlet {

    protected String getProductDescription(Product product) {
        StringBuilder result = new StringBuilder();
        result.append("<html><body>")
                .append("<h1>Product:</h1>")
                .append("<h2>")
                .append(product.getName())
                .append("</h2><p>")
                .append(product.getDescription())
                .append("</p>")
                .append("<h3>")
                .append(product.getPrice())
                .append("</h3><a href='/'>&lt; home page</a></body></html>");

        return result.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));
        Product product = MainPageServlet.products.get(productId);
        resp.getOutputStream().print(getProductDescription(product));
        resp.getOutputStream().flush();
    }
}
