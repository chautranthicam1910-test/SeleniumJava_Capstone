package com.automation.pages;

import com.automation.core.BasePage;
import com.automation.core.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MovieDetailPage extends BasePage {

    private By getmovieTitle(String movieTitle ) {
        return By.xpath("//h1[contains(text(), '" + movieTitle + "')]");
    }

    private final By btnBuyTicketDetail = By.xpath("//a[normalize-space()='Mua vé']");


    @Step("Verify Detail page is displayed")
    public boolean isDetailPageDisplayed() {
        return isDisplayed(btnBuyTicketDetail) && DriverManager.getDriver().getCurrentUrl().contains("/detail/");
    }

    @Step("Verify movie title is displayed correctly")
    public boolean isMovieTitleDisplayed(String expectedTitle) {
        String actualTitle = getText(getmovieTitle(expectedTitle));
        return actualTitle.equalsIgnoreCase(expectedTitle);
    }



}
