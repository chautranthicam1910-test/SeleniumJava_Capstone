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


    //Search section
    private final By ddlMovie = By.xpath("//select[@name='film']");
    private final By ddlCinema   = By.xpath("//select[@name='cinema']");
    private final By ddlShowtime = By.xpath("//select[@name='date']");
    private final By btnBuyTicket = By.xpath("//span[normalize-space()='MUA VÉ NGAY']");
    private final By lblAlertTitle = By.id("swal2-title");
    private final By btnConfirmAlert = By.xpath("//button[contains(text(),'Đã hiểu')]");


    @Step("Select movie")
    public void selectMovieFromDropdown(String movieName) {
        selectByVisibleText(ddlMovie, movieName);

    }

    @Step("Select cinema branch")
    public void selectCinemaBranchFromDropdown(String cinemaBranchName) {
        selectByVisibleText(ddlCinema, cinemaBranchName);
    }

    @Step("Select showtime")
    public void selectShowtimeFromDropdown() {
        selectByIndex(ddlShowtime, 1);
    }

    @Step("Click 'Mua vé ngay'")
    public void clickBuyTicket() {
        click(btnBuyTicket);
    }

    @Step ("Get alert title")
    public String getAlertTitle() {
        return getText(lblAlertTitle);
    }

    @Step ("Click confirm button on alert")
    public void clickConfirmAlert() {
        click(btnConfirmAlert);
    }

    }
