package com.jaxrs.resource;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Api("Test API")
@Path("/test")
public class TestRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String searchNewspaperArticleData() {
        return "App up and running";
    }
}
