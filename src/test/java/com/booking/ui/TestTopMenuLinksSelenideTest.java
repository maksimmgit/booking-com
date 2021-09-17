package com.booking.ui;

import com.booking.pages.MainPageMenuSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ui.core.Driver;

import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestTopMenuLinksSelenideTest {
    static MainPageMenuSelenide mainPageMenu;
    //static Logger logManager;

    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        mainPageMenu = new MainPageMenuSelenide();
        //logManager = LogManager.getLogger(TestTopMenuLinksSelenide.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }



    //Жильё
    private final SelenideElement STAYS_XPATCH_INACTIVE = $x("//span[contains(text(),'Жилье')]");
    private final SelenideElement STAYS_XPATCH_ACTIVE = $x("//link[@href=\"https://www.booking.com/index.ru.html\"]");
    //перелёты
    private final SelenideElement FLIGHTS_XPATCH_INACTIVE = $x("//span[contains(text(),'Авиабилеты')]");
    private final SelenideElement FLIGHTS_XPATCH_ACTIVE = $x("//link[@href=\"https://www.booking.com/flights/index.ru.html\"]");
    private final SelenideElement FLIGHTS_CHROME_XPATCH_INACTIVE = $x("//*[@id=\"b2indexPage\"]/header/nav[2]/ul/li[2]/a/span[2]");
    private final SelenideElement FLIGHTS_CHROME_XPATCH_ACTIVE = $x("//*[@id=\"app-header\"]/header/nav[2]/div/ul/li[2]/a/span[2]");
    //аренда автомобилей
    private final SelenideElement CAR_RENTAL_XPATCH_INACTIVE = $x("//span[contains(text(),'Аренда машин')]");
    private final SelenideElement CAR_RENTAL_XPATCH_ACTIVE = $x("//link[@href=\"https://www.booking.com/cars/index.ru.html\"]");
    //аттракционы
    private final SelenideElement ATTRACTIONS_XPATCH_INACTIVE = $x("//span[contains(text(),'Варианты досуга')]");
    private final SelenideElement ATTRACTIONS_XPATCH_ACTIVE = $x("//link[@href=\"https://www.booking.com/attractions/index.ru.html\"]");
    //такси
    private final SelenideElement AIRPORT_XPATCH_TAXIS_INACTIVE = $x("//span[contains(text(),'Такси от/до аэропорта')]");
    private final SelenideElement AIRPORT_CSS_TAXIS_ACTIVE = $("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    private final SelenideElement AIRPORT_XPATCH_TAXIS_ACTIVE = $x("//link[@href=\"https://www.booking.com/taxi/index.ru.html\"]");
/*
    //перелёт+отель
    private final SelenideElement FLIGHT_AND_HOTEL_CSS_INACTIVE = $("body > header:nth-child(3) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    private final SelenideElement FLIGHT_AND_HOTEL_CSS_ACTIVE = $x("//div[@class='as-oil-l-wrapper-layout-max-width']");
*/

    private final SelenideElement Flights_Inactive = $x("/html[1]/body[1]/header[1]/nav[2]/ul[1]/li[2]/a[1]/span[2]");
    private final SelenideElement Flights_Active = $x("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/nav[2]/div[1]/ul[1]/li[2]/a[1]/span[2]");


    @Test
    @Order(1)
    public void test1NewTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(Flights_Inactive,Flights_Active));
    }
/*    @org.junit.jupiter.api.Test
    @Order(1)
    public void test1FlightsTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(FLIGHTS_CHROME_XPATCH_INACTIVE, FLIGHTS_CHROME_XPATCH_ACTIVE), "Не соответствует");
    }*/

    @org.junit.jupiter.api.Test
    @Order(2)
    public void test2StaysTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(STAYS_XPATCH_INACTIVE, STAYS_XPATCH_ACTIVE),"CSS локатор не соответствует.");
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    public void test3CarRentalTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(CAR_RENTAL_XPATCH_INACTIVE, CAR_RENTAL_XPATCH_ACTIVE),"CSS локатор не соответствует.");
    }

    @Test
    @Order(4)
    public void test4AttractionsTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(ATTRACTIONS_XPATCH_INACTIVE, ATTRACTIONS_XPATCH_ACTIVE),"CSS локатор не соответствует.");
    }


    @Test
    @Order(5)
    public void test5AirportTaxisTest(){
        Assertions.assertTrue(mainPageMenu.clickAndVerify(AIRPORT_XPATCH_TAXIS_INACTIVE, AIRPORT_XPATCH_TAXIS_ACTIVE),"CSS локатор не соответствует.");
    }


}
