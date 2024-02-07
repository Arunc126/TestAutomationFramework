package org.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {

    private RequestSpecification requestSpecification;

    public RestAssuredUtils(String baseURI) {
        RestAssured.baseURI = baseURI;
        requestSpecification = RestAssured.given();
    }

    // Set request headers
    public void setHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
    }

    // Set request body
    public void setBody(String body) {
        requestSpecification.body(body);
    }

    // Perform GET request
    public Response get(String endpoint) {
        return requestSpecification.get(endpoint);
    }

    // Perform POST request
    public Response post(String endpoint) {
        return requestSpecification.post(endpoint);
    }

    // Perform PUT request
    public Response put(String endpoint) {
        return requestSpecification.put(endpoint);
    }

    // Perform DELETE request
    public Response delete(String endpoint) {
        return requestSpecification.delete(endpoint);
    }

    // Get response body as string
    public String getResponseBody(Response response) {
        return response.getBody().asString();
    }

    // Get response status code
    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }
}
