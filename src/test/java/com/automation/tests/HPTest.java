package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.constants.TestData;
import com.automation.pages.HomePage;
import com.automation.pages.MovieDetailPage;
import com.automation.pages.NavigationBar;
import com.automation.pages.PurchasePage;
import com.automation.utils.AssertUtils;
import org.testng.annotations.Test;

public class HPTest extends BaseTest {

    private final NavigationBar navigationBar = new NavigationBar();
    private final HomePage homePage = new HomePage();
    private final MovieDetailPage movieDetailPage = new MovieDetailPage();
    private final PurchasePage purchasePage = new PurchasePage();

    // Movie section
    @Test
    public void playTrailerSuccess() {

        navigationBar.lnkMovieSchedule();
        homePage.clickPlayTrailer(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(homePage.isTrailerDisplayed(), "(Fail: Popup trailer does not show!)");
        homePage.closeTrailer();
    }

    @Test
    public void clickBuyTicket() {
        navigationBar.lnkMovieSchedule();
        homePage.clickBuyTicket(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(movieDetailPage.isDetailPageDisplayed(), "(Fail: Detail page does not show!)");
        AssertUtils.assertTrue(movieDetailPage.isMovieTitleDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Movie title does not match!)");
    }

    //Cinema section
    @Test
    public void selectMovieShowtime() {

        navigationBar.lnkTheater();
        homePage.selectCinemaBrand(TestData.CINEMA_BRAND);
        homePage.selectCinemaBranch(TestData.CINEMA_BRANCH);
        //AssertUtils.assertTrue(homePage.isMovieShowtimeDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Not found!)");

        homePage.clickFirstShowtime(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(purchasePage.isPurchasePageDisplayed(), "(Fail: Purchase page does not show!)");
        AssertUtils.assertTrue(purchasePage.isMovieNameDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Movie name does not match!)");
    }


}
