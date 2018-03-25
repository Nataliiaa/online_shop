package ua.danit.controllers;

import com.google.common.io.Files;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@WebServlet (name = "assets", urlPatterns = "/assets/*")
public class AssetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        URL resource = getClass().getClassLoader().getResource(".");
        String path = resource.getPath();
        File file = new File(path + pathInfo);
        String mimeType = getServletContext().getMimeType(pathInfo);

        if (file.exists()) {
            resp.setContentType(mimeType);
            resp.getWriter().write(Files.toString(file, Charset.defaultCharset()));
        } else {
            resp.getWriter().write("Can't find file = " + path);
        }
    }
}
