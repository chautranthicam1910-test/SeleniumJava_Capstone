package com.automation.pages;

import com.automation.core.BasePage;
import com.automation.core.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PurchasePage extends BasePage {

    private final By btnConfirmPurchase = By.xpath("//span[contains(text(),'ĐẶT VÉ')]");
    private By getmovieName(String movieName ) {
        return By.xpath("//h3[normalize-space()='" + movieName + "']");
    }

    @Step("Verify Purchase page is displayed")
    public boolean isPurchasePageDisplayed() {
        return isDisplayed(btnConfirmPurchase) && DriverManager.getDriver().getCurrentUrl().contains("/purchase/");

    }

    @Step("Verify movie name is displayed: {movieName}")
    public boolean isMovieNameDisplayed(String movieName) {
        return isDisplayed(getmovieName(movieName));
    }
}
