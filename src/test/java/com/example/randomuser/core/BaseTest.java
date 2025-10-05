package com.example.randomuser.core;

import com.example.randomuser.utils.ApiClient;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class BaseTest {

    protected ApiClient apiClient;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        apiClient = new ApiClient();
    }
}
