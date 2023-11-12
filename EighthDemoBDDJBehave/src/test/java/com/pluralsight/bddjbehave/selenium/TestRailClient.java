package com.pluralsight.bddjbehave.selenium;

import com.gurock.testrail.APIClient;

import java.util.HashMap;
import java.util.Map;

public class TestRailClient {

    public static String TEST_RUN_ID = "17";
    public static String TEST_RAIL_USERNAME = "USERNAME";
    public static String TEST_RAIL_PASSWORD = "PASSWORD";
    public static String TEST_RAIL_ENGINE_URL = "https://USERNAME.testrail.io/";
    public static int TEST_CASE_PASS_STATUS = 1;
    public static int TEST_CASE_FAIL_STATUS = 5;

    public static void addJBehaveTestCaseResults(String testCaseId, int status, String error) {

        String testRunID = TEST_RUN_ID;
        APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);

        client.setUser(TEST_RAIL_USERNAME);
        client.setPassword(TEST_RAIL_PASSWORD);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", status);
        data.put("comment", "The Pluralsight Website JBehave test is executed" + error);

        try {
            client.sendPost("add_result_for_case/" + testRunID + "/" + testCaseId, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}