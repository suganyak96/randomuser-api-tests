package com.example.randomuser.tests;

import com.example.randomuser.core.BaseTest;
import com.example.randomuser.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HappyPathTests extends BaseTest {

    @Test(description = "Verify API returns single random user")
    public void verifySingleUserDefault() {
        Response response = apiClient.get("");
        ResponseValidator.verifyStatusCode(response, 200);
        ResponseValidator.verifyResultsCount(response, 1);
        ResponseValidator.verifyFieldNotNull(response, "results[0].email");
    }

    @Test(description = "Verify multiple users are returned correctly")
    public void verifyMultipleUsers() {
        Response response = apiClient.get("?results=5");
        ResponseValidator.verifyStatusCode(response, 200);
        ResponseValidator.verifyResultsCount(response, 5);
    }

    @Test(description = "Verify gender filter works")
    public void verifyGenderFilter() {
        Response response = apiClient.get("?gender=female&results=3");
        ResponseValidator.verifyStatusCode(response, 200);
        ResponseValidator.verifyGender(response, "female");
    }
}
