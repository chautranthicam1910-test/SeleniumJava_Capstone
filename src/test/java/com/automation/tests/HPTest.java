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
    @Test (description = "HP_08: Play movie trailer successfully")
    public void playTrailerSuccess() {

        navigationBar.lnkMovieSchedule();
        homePage.clickPlayTrailer(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(homePage.isTrailerDisplayed(), "(Fail: Popup trailer does not show!)");
    }

    @Test (description = "HP_09: Close movie trailer successfully")
    public void closeTrailerSuccess() {

        navigationBar.lnkMovieSchedule();
        homePage.clickPlayTrailer(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(homePage.isTrailerDisplayed(), "(Fail: Popup trailer does not show!)");
        homePage.closeTrailer();
    }


    @Test(description = "HP_10: Click 'Mua vé' from 'Lịch chiếu' section")
    public void clickBuyTicket() {
        navigationBar.lnkMovieSchedule();
        homePage.clickBuyTicket(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(movieDetailPage.isDetailPageDisplayed(), "(Fail: Detail page does not show!)");
        AssertUtils.assertTrue(movieDetailPage.isMovieTitleDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Movie title does not match!)");
    }


    //Cinema section
    @Test(description = "HP_16: Navigate to Purchase page from Cinema  section")
    public void selectMovieShowtime() {

        navigationBar.lnkTheater();
        homePage.selectCinemaBrand(TestData.CINEMA_BRAND);
        homePage.selectCinemaBranch(TestData.CINEMA_BRANCH);
        //AssertUtils.assertTrue(homePage.isMovieShowtimeDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Not found!)");

        homePage.clickFirstShowtime(TestData.DEFAULT_MOVIE);
        AssertUtils.assertTrue(purchasePage.isPurchasePageDisplayed(), "(Fail: Purchase page does not show!)");
        AssertUtils.assertTrue(purchasePage.isMovieNameDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Movie name does not match!)");
    }


    //Search section
    @Test(description = "HP_21: Navigate to Purchase page from Search section")
    public void searchMovie() {
        homePage.selectMovieFromDropdown(TestData.DEFAULT_MOVIE);
        homePage.selectCinemaBranchFromDropdown(TestData.CINEMA_BRANCH);
        homePage.selectShowtimeFromDropdown();
        homePage.clickBuyTicket();
        AssertUtils.assertTrue(purchasePage.isPurchasePageDisplayed(), "(Fail: Purchase page does not show!)");
        AssertUtils.assertTrue(purchasePage.isMovieNameDisplayed(TestData.DEFAULT_MOVIE), "(Fail: Movie name does not match!)");
    }

    @Test(description = "HP_22: Click 'MUA VÉ NGAY' without selecting movie")
    public void clickBuyTicketWithoutSelectingMovie() {
        homePage.clickBuyTicket();
        //Verify alert title
        String actualAlertTitle = homePage.getAlertTitle();
        AssertUtils.assertEquals(actualAlertTitle, "Bạn chưa chọn phim");
        homePage.clickConfirmAlert();

    }

    @Test(description = "HP_23: Click 'MUA VÉ NGAY' without selecting cinema branch")
    public void clickBuyTicketWithoutSelectingCinemaBranch() {
        homePage.selectMovieFromDropdown(TestData.DEFAULT_MOVIE);
        homePage.clickBuyTicket();
        //Verify alert title
        String actualAlertTitle = homePage.getAlertTitle();
        AssertUtils.assertEquals(actualAlertTitle, "Bạn chưa chọn rạp");
        homePage.clickConfirmAlert();

    }

    @Test (description = "HP_24: Click 'MUA VÉ NGAY' without selecting showtime")
    public void clickBuyTicketWithoutSelectingShowtime() {
        homePage.selectMovieFromDropdown(TestData.DEFAULT_MOVIE);
        homePage.selectCinemaBranchFromDropdown(TestData.CINEMA_BRANCH);
        homePage.clickBuyTicket();
        //Verify alert title
        String actualAlertTitle = homePage.getAlertTitle();
        AssertUtils.assertEquals(actualAlertTitle, "Bạn chưa chọn ngày giờ chiếu");
        homePage.clickConfirmAlert();
    }


}
