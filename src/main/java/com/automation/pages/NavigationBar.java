package com.automation.pages;

import com.automation.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationBar extends BasePage {

    private final By lnkLogin = By.xpath("//a[@href='/sign-in']");

    private final By lnkRegister = By.xpath("//a[@href='/sign-up']");
    private final By imgLogo = By.xpath("//img[@alt='Logo']");
    private final By lnkMovieSchedule = By.xpath("//h4[contains(text(),'Lịch Chiếu')]");
    private final By lnkTheater = By.xpath("//h4[contains(text(),'Cụm Rạp')]");

    @Step("Open login screen")
    public void clickLogin() {
        click(lnkLogin);
    }

    @Step("Open register screen")
    public void clickRegister() {
        click(lnkRegister);
    }

    @Step("Open Movie Schedule screen")
    public void lnkMovieSchedule() {
        click(lnkMovieSchedule);
    }

    @Step("Open Theater screen")
    public void lnkTheater() {
        click(lnkTheater);
    }

    @Step("Open Home screen")
    public void clickLogo() {
        click(imgLogo);
    }

    @Step("Open Movie Schedule screen")
    public void clickMovieSchedule() {
        click(lnkMovieSchedule);
    }

    @Step("Open Theater screen")
    public void clickTheater() {
        click(lnkTheater);
    }
}