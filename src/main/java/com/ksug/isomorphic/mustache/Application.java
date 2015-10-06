package com.ksug.isomorphic.mustache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ScriptTemplateConfigurer handlebarsConfigurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngineName("nashorn");
        configurer.setScripts(
                "/META-INF/resources/webjars/mustache/2.1.2/mustache.js",
                "/static/js/render.js");
        configurer.setRenderFunction("render");
        return configurer;
    }

    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/static/templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }
}
