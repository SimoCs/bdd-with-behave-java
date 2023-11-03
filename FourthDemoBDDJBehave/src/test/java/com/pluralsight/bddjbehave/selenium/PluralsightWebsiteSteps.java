package com.pluralsight.bddjbehave.selenium;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class PluralsightWebsiteSteps {

    private WebDriver driver;

    @Given("I am on the Pluralsight homepage")
    public void givenOnPluralsightHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.pluralsight.com/");
    }

    @Then("the page title should be \"$title\"")
    public void thenPageTitleShouldBe(String title) {
        assertEquals(title, driver.getTitle());
        driver.quit();
    }

}