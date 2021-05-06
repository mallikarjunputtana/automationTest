package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.stepdefinitions.WebDriverSingleton;

public class CarTaxCheckLandingPage {


    WebDriver driver;

    public CarTaxCheckLandingPage() {
        this.driver = WebDriverSingleton.instantiateWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "vrm-input")
    private WebElement vrmInputTextBox;

    @FindBy(xpath = "//button[text()='Free Car Check']")
    private WebElement freeCheck;


    public void enterCarRegistrationNumber(String regNumber) throws InterruptedException {
        vrmInputTextBox.clear();
        vrmInputTextBox.sendKeys(regNumber);
        freeCheck.click();
    }

    private void WaitTillElementPresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void openCarTaxWebSite(){
        driver.navigate().to("https://cartaxcheck.co.uk/");
    }

}
