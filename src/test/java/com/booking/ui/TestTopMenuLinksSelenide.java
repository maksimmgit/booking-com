package com.booking.ui;

import com.booking.pages.MainPageMenu;
import com.booking.pages.MainPageMenuSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.Driver;

import static com.codeborne.selenide.Selenide.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTopMenuLinksSelenide {
    static MainPageMenuSelenide mainPageMenu;

    @BeforeClass
    public static void getDriver(){
        Driver.getDriver();
        mainPageMenu = new MainPageMenuSelenide();
    }

    @AfterClass
    public static void closeDriver(){
        Driver.closeDriver();
    }





    //Жильё
    private final SelenideElement STAYS_LINK_INACTIVE = $("li:nth-child(1) a:nth-child(1) span:nth-child(2)");
    private final SelenideElement STAYS_CSS_LINK_ACTIVE = $("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //перелёты
    private final SelenideElement FLIGHTS_CSS_LINK_INACTIVE = $("header[class='bui-header bui-header--logo-large bui-u-hidden-print '] li:nth-child(2) a:nth-child(1) span:nth-child(2)");
    private final SelenideElement FLIGHTS_CSS_LINK_ACTIVE = $("a[class='Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG'] span[class='Tab-module__text___2vXbZ']");
    //аренда автомобилей
    private final SelenideElement CAR_RENTAL_CSS_INACTIVE = $("header[class='bui-header bui-header--logo-large bui-u-hidden-print '] li:nth-child(3) a:nth-child(1) span:nth-child(2)");
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
    @DisplayName("Авиабилеты")
    public void test1FlightsTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(FLIGHTS_CSS_LINK_INACTIVE, FLIGHTS_CSS_LINK_ACTIVE));
    }

    @Test
    @DisplayName("Жильё")
    public void test2StaysTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(STAYS_LINK_INACTIVE, STAYS_CSS_LINK_ACTIVE));
    }

    @Test
    @DisplayName("Аренда автомобилей")
    public void test3CarRentalTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(CAR_RENTAL_CSS_INACTIVE, CAR_RENTAL_CSS_ACTIVE));
    }

    @Test
    @DisplayName("Варианты досуга")
    public void test4AttractionsTest(){
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(ATTRACTIONS_CSS_INACTIVE, ATTRACTIONS_CSS_ACTIVE));
    }


    @Test
    @DisplayName("Такси от/до аэропорта")
    public void test5AirportTaxisTest(){
        Assert.assertTrue("Не соответствует.", mainPageMenu.clickAndVerify(AIRPORT_XPATCH_TAXIS_INACTIVE, AIRPORT_LINK_TAXIS_ACTIVE));
    }

/*    @Test
    @DisplayName("Перелёт и отель")
    public void test6FlightAndHotelTest(){
        MainPageMenuSelenide mainPageMenu = new MainPageMenuSelenide();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(FLIGHT_AND_HOTEL_CSS_INACTIVE, FLIGHT_AND_HOTEL_CSS_ACTIVE));
    }*/


}
