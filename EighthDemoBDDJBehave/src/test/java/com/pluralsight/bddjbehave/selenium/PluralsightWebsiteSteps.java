package com.pluralsight.bddjbehave.selenium;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class PluralsightWebsiteSteps {

    private WebDriver driver;
    protected String testCaseId;
    private boolean results;


    @Given("I am on the Pluralsight homepage")
    public void givenOnPluralsightHomepage() {
        try {
            driver = new ChromeDriver();
            driver.get("https://www.pluralsight.com/");

            results = true;
        } catch (Exception e) {
            results = false;
        }
    }

    @Then("the page title should be \"$title\"")
    public void thenPageTitleShouldBe(String title) {
        testCaseId = "2147";

        try {
            assertEquals(title, driver.getTitle());
            driver.quit();

            results = true;
        } catch (Exception e) {
            results = false;
        }
    }

    @AfterScenario(uponType = ScenarioType.ANY)
    public void addResultsToTestRail() {

        if (results){
            TestRailClient.addJBehaveTestCaseResults(testCaseId, TestRailClient.TEST_CASE_PASS_STATUS, "");
        }
        else{
            TestRailClient.addJBehaveTestCaseResults(testCaseId, TestRailClient.TEST_CASE_FAIL_STATUS, "FailureInStories");
        }
    }

}