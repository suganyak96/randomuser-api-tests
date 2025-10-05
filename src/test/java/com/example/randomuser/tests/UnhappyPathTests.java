package com.example.randomuser.tests;

import com.example.randomuser.core.BaseTest;
import com.example.randomuser.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UnhappyPathTests extends BaseTest {

    @Test(description = "Invalid parameter should not crash API")
    public void testInvalidParameter() {
        Response response = apiClient.get("?invalidParam=xyz");
        ResponseValidator.verifyStatusCode(response, 200);
    }

    @Test(description = "Invalid gender should still return data")
    public void testInvalidGenderFallback() {
        Response response = apiClient.get("?gender=invalid");
        ResponseValidator.verifyStatusCode(response, 200);
    }

    @Test(description = "Large results value should be handled gracefully")
    public void testLargeResults() {
        Response response = apiClient.get("?results=10000");
        ResponseValidator.verifyStatusCode(response, 200);
        int count = response.jsonPath().getList("results").size();
        assert count <= 5000 : "API should cap results count";
    }
}
