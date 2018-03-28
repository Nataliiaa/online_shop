package ua.danit.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Map;

import static freemarker.template.Configuration.VERSION_2_3_21;

public class TemplateLoader {

    public static final TemplateLoader TEMPLATE_LOADER = new TemplateLoader();

    public Template getTemplate(String name) throws IOException {
        Configuration config = new Configuration(VERSION_2_3_21);
        URL resource = getClass().getClassLoader().getResource(".");
        String path = resource.getPath();
        config.setDirectoryForTemplateLoading(new File(path));
        return config.getTemplate(name);
    }

    public void write(String template, Writer out, Map data) throws IOException {
        try {
            getTemplate(template).process(data, out);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
