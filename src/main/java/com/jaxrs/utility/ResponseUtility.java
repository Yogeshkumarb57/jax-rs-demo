package com.jaxrs.utility;

import javax.ws.rs.core.Response;
import java.util.Map;

public class ResponseUtility {

    private static ResponseUtility responseUtility = null;

    private ResponseUtility() {
    }

    public static ResponseUtility getInstance() {
        if (responseUtility == null) {
            responseUtility = new ResponseUtility();
        }
        return responseUtility;
    }

    public Response generateResponse(Response.Status status, Map<String, Object> headers, Object data) {
        Response.ResponseBuilder responseBuilder = Response.status(status);
        if (headers != null) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                responseBuilder.header(entry.getKey(), entry.getValue());
            }
        }
        responseBuilder = responseBuilder.entity(data);
        return responseBuilder.build();
    }

}
