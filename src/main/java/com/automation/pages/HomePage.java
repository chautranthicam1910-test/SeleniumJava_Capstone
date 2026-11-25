package com.automation.pages;

import com.automation.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    //Movie section

    //Locator for movie card based on movie name
    private By getMovieCard(String movieName) {
        return By.xpath("//a[contains(@href, '/detail/') and .//*[contains(text(), '" + movieName + "')]]");
    }

    private By getBtnBuyTicket(String movieName) {
        return By.xpath("//a[contains(@href, '/detail/') and .//*[contains(text(), '" + movieName + "')]]//a[text()='MUA VÉ']");
    }

    private By getBtnPlayTrailer(String movieName) {
        return By.xpath("//a[contains(@href, '/detail/') and .//*[contains(text(), '" + movieName + "')]]//img[@alt='video-button']/ancestor::button");
    }

    // Trailer popup locators
    private final By trailerModal = By.xpath("//div[@class='modal-video' and @role='dialog']");
    private final By btnCloseTrailer = By.xpath("//button[@class='modal-video-close-btn']");


    @Step("Hover and Click Buy Ticket for movie: {movieName}")
    public void clickBuyTicket(String movieName) {

        hoverAndClick(getMovieCard(movieName), getBtnBuyTicket(movieName));
    }

    @Step ("Hover and Click Play Trailer for movie: {movieName}")
    public void clickPlayTrailer(String movieName) {
    hoverAndClick(getMovieCard(movieName), getBtnPlayTrailer(movieName));
    }

    @Step("Verify trailer popup is displayed")
    public boolean isTrailerDisplayed() {
        return isDisplayed(trailerModal);
    }

    @Step("Close trailer popup")
    public void closeTrailer() {
        click(btnCloseTrailer);
    }

    //Cinema section

    private By getCinemaCard(String cinemaName) {
        return By.xpath("//img[@alt='"+ cinemaName +"']");
    }

    private By getCinemaBranch(String cinemaBranchName){
        return By.xpath("//h4[normalize-space()='"+ cinemaBranchName +"']");
    }

    private By getMovieSchedule(String movieName) {
        return By.xpath("//img[@alt='"+ movieName +"']");
    }

    private By getBtnSelectShowTime(String movieName) {
        return By.xpath("(//div[contains(@id,'vertical-tabpanel')]//img[@alt='" + movieName + "']/following::a[contains(@href,'/purchase/')])[1]");
    }

    @Step("Select cinema brand: {cinemaName}")
    public void selectCinemaBrand(String cinemaName ) {
        click(getCinemaCard(cinemaName));
    }

    @Step("Select cinema branch: {cinemaBranchName}")
    public void selectCinemaBranch(String cinemaBranchName) {
        click(getCinemaBranch(cinemaBranchName));
    }

    @Step("Check movie showtime")
    public boolean isMovieShowtimeDisplayed(String movieName) {
        return isDisplayed(getMovieSchedule(movieName));
    }

    @Step("Select first showtime for the selected movie")
    public void clickFirstShowtime(String movieName) {
        click(getBtnSelectShowTime(movieName));
    }


}
