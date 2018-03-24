package ua.danit.controllers;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.danit.service.ProductService.PRODUCT_SERVICE;

@WebServlet(name = "productsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(PRODUCT_SERVICE.getAllProducts());
        response.getWriter().write(json);
    }

}
