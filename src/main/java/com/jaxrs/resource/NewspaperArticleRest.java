package com.jaxrs.resource;

import com.jaxrs.model.Article;
import com.jaxrs.utility.TheHinduSiteDataReadUtility;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/article")
public class NewspaperArticleRest {

    @GET
    @Path("/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAuthors() {
        return TheHinduSiteDataReadUtility.getAllAuthors();
    }

    @GET
    @Path("/authors/{authorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getArticlesByAuthor(@PathParam("authorName") String authorName) {
        return TheHinduSiteDataReadUtility.getAllArticlesByAuthor(authorName);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> searchNewspaperArticleData(@QueryParam("title") String title, @QueryParam("description") String description) {
        return TheHinduSiteDataReadUtility.getAllArticlesByTitleDesc(title, description);
    }
}
