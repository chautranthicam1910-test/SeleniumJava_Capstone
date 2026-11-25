package com.automation.core;

import com.automation.utils.LogUtils;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.awt.SystemColor.text;

public class BasePage {

    //Click
    protected void click(By locator) {

        // Log the click action for better traceability
        LogUtils.stepLog("Clicking on element: " + locator);
        WaitUtils.waitForVisibility(locator).click();
    }

    //Type
    protected void type(By locator, String text) {

        // Log the typing action for better traceability
        LogUtils.stepLog("Typing text '" + text + "' into element: " + locator);

        WaitUtils.waitForVisibility(locator).clear(); // Clear the input field before typing
        WaitUtils.waitForVisibility(locator).sendKeys(text);
    }

    //Get Text
    protected String getText(By locator) {

        // Log the get text action for better traceability
        LogUtils.stepLog("Getting text from element: " + locator);

        return WaitUtils.waitForVisibility(locator).getText();
    }

    //Is Displayed
    protected boolean isDisplayed(By locator) {

        // Log the is displayed action for better traceability
        LogUtils.stepLog("Checking if element is displayed: " + locator);

        return WaitUtils.waitForVisibility(locator).isDisplayed();
    }

    // Scroll to element
    protected void scrollToElement(By locator) {
        LogUtils.stepLog("Scrolling to element: " + locator);
        WebElement element = WaitUtils.waitForVisibility(locator);
        new Actions(DriverManager.getDriver()).scrollToElement(element).perform();
    }

    // Hover and Click
    protected void hoverAndClick(By hoverLocator, By clickLocator) {
        LogUtils.stepLog("Hovering on: " + hoverLocator + " and clicking: " + clickLocator);

        // 1. Find the hover element and wait for it to be visible
        WebElement hoverElement = WaitUtils.waitForVisibility(hoverLocator);

        // 2. Scroll to the hover element and perform hover action to reveal the clickable element
        Actions actions = new Actions(DriverManager.getDriver());
        actions.scrollToElement(hoverElement).moveToElement(hoverElement).perform();

        // 3. Wait for the clickable element (MUA VÉ or Play button) to be visible and click it
        WebElement clickElement = WaitUtils.waitForVisibility(clickLocator);
        clickElement.click();
    }

}