package com.booking.ui;

import com.booking.ui.pages.BookingPages;
import com.booking.ui.testSource.BookingSource;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ui.core.Driver;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingProcessTest {

    static BookingPages bookingPages;
    private static Logger logger = Logger.getLogger(BookingProcessTest.class);

    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        bookingPages = new BookingPages();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }

    @Test
    @Step("Switch currency to USD")
    @Order(1)
    @Disabled // Noncompliant
    public void testChangeCurrencyToUSD(){
        logger.debug("Switch currency to USD");
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
        logger.debug("Choosing destination: " + query);
        Assertions.assertTrue(bookingPages.chooseDestination(query, matches), "Не совпадает город");
    }


    @Test
    @Step("Choose dates")
    @Order(3)
    public void testChooseDates(){
        logger.debug("Choosing dates");
        Assertions.assertTrue(bookingPages.chooseDates(), "Не удалось проверить или поменять дату.");
    }

    @Test
    @Step("Add chindren")
    @Order(4)
    public void testAddChild(){
        logger.debug("Adding children");
        Assertions.assertTrue(bookingPages.chooseGuestAmount(8), "Не смогли обработать добавление ребёнка.");
    }

    @Test
    @Step("Click to the Search button")
    @Order(5)
    public void testCheckSearchResultsPage(){
        logger.debug("Click to the search button");
        Assertions.assertTrue(bookingPages.clickToTheSearchButton(),"Неправильно перешли в результаты поиска.");
    }

    @Test
    @Step("Choosing hotel rate")
    @Order(6)
    public void testChooseAndCheckHotel(){
        logger.debug("Choose 5 stars hotels filter");
        Assertions.assertTrue(bookingPages.chooseAFiveStarHotel("5"),"Ошибка в выборе звёзд отеля");
    }

    @Test
    @Step("Choosing a room")
    @Order(7)
    public void testChooseRoom(){
        logger.debug("Choosing a room");
        Assertions.assertTrue(bookingPages.chooseAHotel(), "Не удалось выбрать конкретный номер.");
    }

    @ParameterizedTest
    @ArgumentsSource(BookingSource.class)
    @Step("Entering personal details")
    @Order(8)
    public void testFillingFinalForm(String name, String surname, String email, String request){
        logger.debug("Entering current personal details. \nName: "+ name
                +"\nSurname: "+ surname
        +"\nEmail: " + email);
        Assertions.assertTrue(bookingPages.completeRegistrationProcess(name, surname, email, request), "Не удалось подтвердить номер.");
    }
}
