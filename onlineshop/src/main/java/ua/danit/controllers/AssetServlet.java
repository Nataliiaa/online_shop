package ua.danit.controllers;

import com.google.common.io.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@WebServlet(name = "assets", urlPatterns = "/assets/*")
public class AssetServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        File file = new File("resources"+path);
        if(file.exists()){
            resp.getWriter().write(Files.toString(file, Charset.defaultCharset()));
        } else {
            resp.getWriter().write("Can't find file = " + path);
        }

    }
}
