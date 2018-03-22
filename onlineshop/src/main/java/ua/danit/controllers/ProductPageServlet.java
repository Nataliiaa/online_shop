package ua.danit.controllers;

import ua.danit.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "productPage    Servlet", urlPatterns = "/product/")
public class ProductPageServlet extends HttpServlet {

    private String buildProductDescriptionPage(Product product) {
        StringBuilder result = new StringBuilder();
        result.append("<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">")
                .append("<body>")
                .append("<h1>Product:</h1>")
                .append("<h2>")
                .append(product.getTitle())
                .append("</h2><p>")
                .append("<img src='")
                .append(product.getImageUrl())
                .append("' width='400px'></p><p>")
                .append(product.getDescription())
                .append("</p>")
                .append("<h3>$")
                .append(product.getPrice())
                .append("</h3><p><form method='POST' action='/cart/products'>")
                .append("<input type='hidden' name='productId' value='")
                .append(product.getId())
                .append("'>")
                .append("<button type='submit'>Add to Cart</button>")
                .append("</form></p>")
                .append("<p><a href='/'>&lt; home page</a></p></body></html>");

        return result.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));
        Product product = MainPageServlet.products.get(productId);
        resp.getOutputStream().print(buildProductDescriptionPage(product));
        resp.getOutputStream().flush();
    }
}
