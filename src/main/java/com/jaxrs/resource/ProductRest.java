package com.jaxrs.resource;

import com.jaxrs.model.Product;
import com.jaxrs.service.ProductService;
import com.jaxrs.service.ProductServiceImpl;
import com.jaxrs.utility.ResponseUtility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api(value = "Products Rest Service", description = "Products rest service")
@Path("/products")
public class ProductRest {

	/*@Context
    private ServletContext servletContext;*/

    //@Inject
    private ProductService productService = new ProductServiceImpl();

    @ApiOperation(value = "Get product service", notes = "Gets product by product id.")
    @GET
    @Path("/{productId}")
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Response getProduct(@PathParam("productId") Integer productId) {
        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                productService.getProduct(productId));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    @ApiOperation(value = "Get all products service", notes = "Gets all products.")
    public Response getAllProducts() {
        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                productService.getAllProducts());
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add product service", notes = "Adds product from product detail.")
    public Response addProduct(Product product) {
        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                productService.saveProduct(product));
    }

    @DELETE
    @Path("/{productId}")
    @Produces({MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    @ApiOperation(value = "Delete product service", notes = "Deletes product by product id.")
    public Response deleteProduct(@PathParam("productId") Integer productId) {
        return ResponseUtility.getInstance().generateResponse(Response.Status.OK, null,
                productService.deleteProduct(productId));
    }

}

