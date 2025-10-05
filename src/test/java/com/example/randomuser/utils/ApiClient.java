package com.example.randomuser.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    private final String baseUrl;

    public ApiClient() {
        this.baseUrl = ConfigManager.get("base.url");
    }

    private RequestSpecification baseRequest() {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .log().uri();
    }

    public Response get(String endpoint) {
        return baseRequest()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endpoint, Object body) {
        return baseRequest()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    
}
