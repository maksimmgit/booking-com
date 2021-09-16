package com.booking.ui;

import com.booking.pages.MainPageMenuSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.Tags;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;
import org.junit.runners.MethodSorters;
import ui.core.Driver;

import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTopMenuLinksSelenideTest {
    static MainPageMenuSelenide mainPageMenu;
    //static Logger logManager;

    @BeforeClass
    public static void getDriver(){
        Driver.getDriver();
        mainPageMenu = new MainPageMenuSelenide();
        //logManager = LogManager.getLogger(TestTopMenuLinksSelenide.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterClass
    public static void closeDriver(){
        Driver.closeDriver();
    }





    //Жильё
    private final SelenideElement STAYS_LINK_INACTIVE = $x("//span[contains(text(),'Жилье')]");
    private final SelenideElement STAYS_CSS_LINK_ACTIVE = $("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //перелёты
    private final SelenideElement FLIGHTS_CSS_LINK_INACTIVE = $x("//span[contains(text(),'Авиабилеты')]");
    private final SelenideElement FLIGHTS_CSS_LINK_ACTIVE = $("a[class='Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG'] span[class='Tab-module__text___2vXbZ']");
    //аренда автомобилей
    private final SelenideElement CAR_RENTAL_CSS_INACTIVE = $x("//span[contains(text(),'Аренда машин')]");
    private final SelenideElement CAR_RENTAL_CSS_ACTIVE = $("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //аттракционы
    private final SelenideElement ATTRACTIONS_CSS_INACTIVE = $x("//span[contains(text(),'Варианты досуга')]");
    private final SelenideElement ATTRACTIONS_CSS_ACTIVE = $("a[class='Actionable-module__root___3GRl0 Tab-module__link___vI35C Tab-module__link--selected___3qmZH'] span[class='Tab-module__text___3vSL-'] span");
    //такси
    private final SelenideElement AIRPORT_XPATCH_TAXIS_INACTIVE = $x("//span[contains(text(),'Такси от/до аэропорта')]");
    private final SelenideElement AIRPORT_CSS_TAXIS_ACTIVE = $("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    private final SelenideElement AIRPORT_LINK_TAXIS_ACTIVE = $x("//title[\"Забронируйте такси от/до аэропорта онлайн | Booking.com\"]");
/*
    //перелёт+отель
    private final SelenideElement FLIGHT_AND_HOTEL_CSS_INACTIVE = $("body > header:nth-child(3) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    private final SelenideElement FLIGHT_AND_HOTEL_CSS_ACTIVE = $x("//div[@class='as-oil-l-wrapper-layout-max-width']");
*/



    @Test
    @Step("Авиабилеты")
    public void test1FlightsTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(FLIGHTS_CSS_LINK_INACTIVE, FLIGHTS_CSS_LINK_ACTIVE));
    }

    @Test
    public void test2StaysTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(STAYS_LINK_INACTIVE, STAYS_CSS_LINK_ACTIVE));
    }

    @Test
    public void test3CarRentalTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(CAR_RENTAL_CSS_INACTIVE, CAR_RENTAL_CSS_ACTIVE));
    }

    @Test
    public void test4AttractionsTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(ATTRACTIONS_CSS_INACTIVE, ATTRACTIONS_CSS_ACTIVE));
    }


    @Test
    public void test5AirportTaxisTest(){
        Assert.assertTrue("Не соответствует.", mainPageMenu.clickAndVerify(AIRPORT_XPATCH_TAXIS_INACTIVE, AIRPORT_LINK_TAXIS_ACTIVE));
    }


}
