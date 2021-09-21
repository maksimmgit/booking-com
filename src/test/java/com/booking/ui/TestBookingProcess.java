package com.booking.ui;

import com.booking.pages.BookingPages;
import com.booking.pages.MainPageLanguages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Disabled
    public void testChangeCurrencyToUSD(){
        Assertions.assertTrue(bookingPages.switchCurrency(), "Неправильно поменяли валюту на USD.");
    }

    static Stream<Arguments> stringProvider() {
        return Stream.of(
                arguments("Breuil", "Breuil-Cervinia, Valle d\'Aosta, Italy")
        );
    }

    @ParameterizedTest
    @Step("Choose destination")
    @Order(2)
    @MethodSource("stringProvider")
    public void testChooseDestination(String query, String matches){
        Assertions.assertTrue(bookingPages.chooseDestination(query, matches), "Не совпадает город");
    }


    @Test
    @Step("Choose dates")
    @Order(3)
    public void testChooseDates(){
        Assertions.assertTrue(bookingPages.chooseDates(), "Не удалось проверить или поменять дату.");
    }

    @Test
    @Step
    @Order(4)
    public void testAddChild(){
        Assertions.assertTrue(bookingPages.chooseGuestAmount(8), "Не смогли обработать добавление ребёнка.");
    }

    @Test
    @Step
    @Order(5)
    public void testCheckSearchResultsPage(){
        Assertions.assertTrue(bookingPages.clickToTheSearchButton(),"Неправильно перешли в результаты поиска.");
    }

    @Test
    @Step
    @Order(6)
    public void testChooseAndCheckHotel(){
        Assertions.assertTrue(bookingPages.chooseAFiveStarHotel("5"),"Ошибка в выборе звёзд отеля");
    }
}
