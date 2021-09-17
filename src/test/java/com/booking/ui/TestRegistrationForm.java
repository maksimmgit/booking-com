package com.booking.ui;

import com.booking.pages.MainPageMenuSelenide;
import com.booking.pages.RegistrationForm;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestRegistrationForm {

    static RegistrationForm registrationForm;


    @BeforeAll
    public static void getDriver(){
        Driver.getDriver();
        registrationForm = new RegistrationForm();
        //logManager = LogManager.getLogger(TestTopMenuLinksSelenide.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().savePageSource(false).screenshots(true));
    }

    @AfterAll
    public static void closeDriver(){
        Driver.closeDriver();
    }

    @Test
    @Step("Click on the register button")
    public void test1ClickOnTheRegisterButton(){
        Assertions.assertTrue(registrationForm.moveToEmailPage(),"Ошибка при переходе на страницу регистрации");
    }

    @Step("Перебираем плохие вариации почты")
    @ParameterizedTest
    @ValueSource(strings = {"mail", "mail@", "mail@.","mail@domain.", "mail@.com", "еуые@еуыеюсщь", "mail@mail,com"})
    public void test2CheckWrongEmailFormats(String s){
        Assertions.assertFalse( registrationForm.inputWrongEmail(s),"Почту приняло");
    }
}
