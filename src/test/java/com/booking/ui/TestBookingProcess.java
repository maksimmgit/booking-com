package com.booking.ui;

import com.booking.pages.BookingPages;
import com.booking.pages.MainPageLanguages;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

public class TestBookingProcess {

    static BookingPages bookingPages;

    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        bookingPages = new BookingPages();
        //logManager = LogManager.getLogger(TestTopMenuLinksSelenide.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }

    @Test
    @Step("Switch currency to USD")
    @Order(1)
    public void testChangeCurrencyToUSD(){
        Assertions.assertTrue(bookingPages.switchCurrency(), "Неправильно поменяли валюту на USD.");
    }

    @ParameterizedTest
    @Step("Choose destination")
    @Order(2)
    @ValueSource(strings = {"Breuil","Breuil-Cervinia"})
    public void testChooseDestination(String query, String matches){
        Assertions.assertTrue(bookingPages.switchCurrency(), "Неправильно поменяли валюту на USD.");
    }
}
