package com.booking.ui;

import com.booking.pages.MainPageLanguages;
import com.booking.pages.RegistrationForm;
import com.codeborne.selenide.commands.As;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ui.core.Driver;

public class LanguageChangeTest {

    static MainPageLanguages mainPageLanguages;

    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        mainPageLanguages = new MainPageLanguages();
        //logManager = LogManager.getLogger(TestTopMenuLinksSelenide.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }

    @Test
    @Step("Switch to EN_GB")
    @Order(1)
    public void testChangeEngGB(){
        Assertions.assertTrue(mainPageLanguages.switchToGBCheck(), "Неправильно поменяли язык на EN_GB");
    }

    @Test
    @Step("Switch to EN_US")
    @Order(2)
    public void testChangeEngUS(){
        Assertions.assertTrue(mainPageLanguages.switchToUSCheck(),"Неправильно поменяли язык на EN_US");
    }

    @Test
    @Step("Switch to DE")
    @Order(3)
    public void testChangeDE(){
        Assertions.assertTrue(mainPageLanguages.switchToDECheck(),"Неправильно поменяли язык на DE");
    }

    @Test
    @Step("Switch to IT")
    @Order(4)
    public void testChangeIT(){
        Assertions.assertTrue(mainPageLanguages.switchToITCheck(),"Неправильно поменяли язык на IT");
    }

    @Test
    @Step("Switch to PL")
    @Order(5)
    public void testChangePL(){
        Assertions.assertTrue(mainPageLanguages.switchToPLCheck(),"Неправильно поменяли язык на PL");
    }

}
