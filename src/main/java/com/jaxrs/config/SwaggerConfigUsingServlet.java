package com.jaxrs.config;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import io.swagger.models.auth.OAuth2Definition;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SwaggerConfigUsingServlet extends HttpServlet {
    /*@Override
    public void init(ServletConfig config) throws ServletException {
        *//*Info info = new Info()
                .title("Rest APIs using JAX-RS")
                .description("Using jersey as implementation and documentation with swagger")
                .termsOfService("")
                .contact(new Contact()
                        .email("yogeshkumarb57@gmail.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        ServletContext context = config.getServletContext();
        Swagger swagger = new Swagger().info(info);
        *//**//*swagger.securityDefinition("api_key", new ApiKeyAuthDefinition("api_key", In.HEADER));
        swagger.securityDefinition("petstore_auth",
                new OAuth2Definition()
                        .implicit("http://petstore.swagger.io/api/oauth/dialog")
                        .scope("read:pets", "read your pets")
                        .scope("write:pets", "modify pets in your account"));*//**//*
        new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
    }*/
}