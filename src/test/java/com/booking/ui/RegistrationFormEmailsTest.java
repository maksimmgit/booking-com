package com.booking.ui;

import com.booking.ui.pages.RegistrationForm;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

public class RegistrationFormEmailsTest {
    static RegistrationForm registrationForm;
    private static Logger logger = Logger.getLogger(RegistrationFormEmailsTest.class);


    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        registrationForm = new RegistrationForm();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }

    @Test
    @Step("Click on the register button")
    public void test1ClickOnTheRegisterButton(){
        logger.debug("Click on the register button");
        Assertions.assertTrue(registrationForm.moveToEmailPage(),"Ошибка при переходе на страницу регистрации");
    }

    @Step("Перебираем плохие вариации почты")
    @ParameterizedTest
    @ValueSource(strings = {"mail", "mail@", "mail@.","mail@domain.", "mail@.com", "еуые@еуыеюсщь", "mail@mail,com"})
    public void test2CheckWrongEmailFormats(String s){
        logger.debug("Checking bad emails");
        Assertions.assertFalse( registrationForm.inputWrongEmail(s),"Почту приняло");
    }
}
