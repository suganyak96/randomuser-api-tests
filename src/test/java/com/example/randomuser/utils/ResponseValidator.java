package com.example.randomuser.utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class ResponseValidator {

    public static void verifyStatusCode(Response response, int expected) {
        Assert.assertEquals(response.statusCode(), expected,
                "Unexpected status code");
    }

    public static void verifyResultsCount(Response response, int expectedCount) {
        int actual = response.jsonPath().getList("results").size();
        Assert.assertEquals(actual, expectedCount, "Unexpected number of results");
    }

    public static void verifyGender(Response response, String expectedGender) {
        List<String> genders = response.jsonPath().getList("results.gender");
        for (String gender : genders) {
            Assert.assertEquals(gender, expectedGender, "Gender mismatch found!");
        }
    }

    public static void verifyFieldNotNull(Response response, String jsonPath) {
        Object value = response.jsonPath().get(jsonPath);
        Assert.assertNotNull(value, "Field " + jsonPath + " should not be null");
    }
}
