package com.jaxrs.config;

import com.jaxrs.resource.NewspaperArticleRest;
import com.jaxrs.resource.ProductRest;
import com.jaxrs.resource.TestRest;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.core.Application;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class SwaggerConfig extends Application {
    public SwaggerConfig() {

        String host = null;
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            host = inetAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost(host + ":7000");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(ProductRest.class);
        resources.add(NewspaperArticleRest.class);
        resources.add(TestRest.class);

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}