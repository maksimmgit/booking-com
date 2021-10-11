package com.booking.ui;

import com.booking.ui.pages.RegistrationForm;
import com.booking.ui.testSource.DetailsPageSourse;
import com.booking.ui.testSource.LoginEmail;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationProcessTest {
    static RegistrationForm registrationForm;
    private static Logger logger = Logger.getLogger(RegistrationProcessTest.class);


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
    @Step("Переходим на страницу ввода почты")
    @Order(1)
    public void testRegistrationPageButton(){
        logger.debug("Enter email address");
        Assertions.assertTrue(registrationForm.moveToEmailPage(),"Неправильно перешли по ссылке.");
    }

    @ParameterizedTest
    @Step("Вводим почту и переходим на страницу ввода пароля.")
    @Order(2)
    @ArgumentsSource(LoginEmail.class)
    public void testEnterEmailNavigateToPasswordPage(String s){
        logger.debug("Used email address is " + s);
        Assertions.assertTrue(registrationForm.inputCorrectEmail(s),"Почту приняло");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789aA!!!!"})
    @Step("Вводим пароль и подтверждаем страницу.")
    @Order(3)
    public void testEnterPasswordNavigateToPersDetails(String s){
        logger.debug("Used password:"+ s);
        Assertions.assertTrue(registrationForm.inputCorrectPassword(s));
    }

    @Test
    @Step("Переход в профиль")
    @Order(4)
    public void testEnterProfile(){
        logger.debug("Moving to the profile");
        Assertions.assertTrue(registrationForm.navigateToPersonalProfile(), "Не удалось перейти в профиль");
    }

    @ParameterizedTest
    @Step("Обновляем информацию профиля, проверка title")
    @Order(5)
    @ArgumentsSource(DetailsPageSourse.class)
    public void testEditProfileInfo(String displayName, String dd, String mm, String yyyy, String fullDob){
        logger.debug("Filling the profile with current name and date of birth: " + displayName +", " + fullDob);
        registrationForm.editPersonalDetails(displayName,dd,mm,yyyy);
        Assertions.assertTrue(registrationForm.checkTitle(), "Не удалось поменять правильно данные");
    }

    @Test
    @Step("Проверка Display name")
    @Order(6)
    public void testCheckDisplayName(){
        logger.debug("Check display name");
        Assertions.assertTrue(registrationForm.checkDisplayName(), "DisplayName не совпадает.");
    }

    @Test
    @Step("Проверка DOB")
    @Order(7)
    public void testCheckDOB(){
        logger.debug("Check date of birth");
        Assertions.assertTrue(registrationForm.checkDOB(), "DOB не совпадает.");
    }
}
