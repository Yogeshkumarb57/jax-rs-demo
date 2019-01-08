package com.demo.jaxrs.resource;

import com.demo.jaxrs.model.Article;
import com.demo.jaxrs.utility.SiteDataReadUtility;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/article")
public class NewspaperArticleRest {

    @GET
    @Path("/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAuthors() {
        return SiteDataReadUtility.getAllAuthors();
    }

    @GET
    @Path("/authors/{authorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getArticlesByAuthor(@PathParam("authorName") String authorName) {
        return SiteDataReadUtility.getAllArticlesByAuthor(authorName);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> searchNewspaperArticleData(@QueryParam("title") String title, @QueryParam("description") String description) {
        return SiteDataReadUtility.getAllArticlesByTitleDesc(title, description);
    }
}
