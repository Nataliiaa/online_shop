package ua.danit.controllers;

import static freemarker.template.Configuration.VERSION_2_3_21;

import com.google.common.collect.ImmutableMap;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ua.danit.service.TemplateLoader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/app")
public class App extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("Ivan", new User("John", null));
        PrintWriter out = resp.getWriter();
        TemplateLoader templateLoader = new TemplateLoader();
        templateLoader.write("app.ftl", out, ImmutableMap.of("user", user));
    }

    public static class User {
        private String name;
        private User friend;

        public User(String name, User friend) {
            this.name = name;
            this.friend = friend;
        }
        public String getName() { return name; }
        public User getFriend() { return friend; }
    }
}