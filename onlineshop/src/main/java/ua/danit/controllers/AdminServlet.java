package ua.danit.controllers;

import ua.danit.service.TemplateLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static ua.danit.service.TemplateLoader.TEMPLATE_LOADER;

@WebServlet (urlPatterns = "/admin", name = "adminServlet")
public class AdminServlet extends HttpServlet{

    private final TemplateLoader templateLoader = TEMPLATE_LOADER;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //templateLoader.write();
    }
}
