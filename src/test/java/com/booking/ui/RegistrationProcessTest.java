package com.booking.ui;

import com.booking.pages.RegistrationForm;
import com.booking.ui.testSource.DetailsPageSourse;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import ui.core.Driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationProcessTest {
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
    @Step("Переходим на страницу ввода почты")
    @Order(1)
    public void testRegistrationPageButton(){
        Assertions.assertTrue(registrationForm.moveToEmailPage(),"Неправильно перешли по ссылке.");
    }

    @ParameterizedTest
    @ValueSource(strings={"testqa5T332340124@yandex.by"})
    @Step("Вводим почту и переходим на страницу ввода пароля.")
    @Order(2)
    public void testEnterEmailNavigateToPasswordPage(String s){
        Assertions.assertTrue(registrationForm.inputCorrectEmail(s),"Почту приняло");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123123!!!!Aaa"})
    @Step("Вводим пароль и подтверждаем страницу.")
    @Order(3)
    public void testEnterPasswordNavigateToPersDetails(String s){
        Assertions.assertTrue(registrationForm.inputCorrectPassword(s));
    }

    @Test
    @Step("Переход в профиль")
    @Order(4)
    public void testEnterProfile(){
        Assertions.assertTrue(registrationForm.navigateToPersonalProfile(), "Не удалось перейти в профиль");
    }

    @ParameterizedTest
    @Step("Обновляем информацию профиля, проверка title")
    @Order(5)
    @ArgumentsSource(DetailsPageSourse.class)
    public void testEditProfileInfo(String displayName, String dd, String mm, String yyyy, String fullDob){
        registrationForm.editPersonalDetails(displayName,dd,mm,yyyy);
        Assertions.assertTrue(registrationForm.checkTitle(), "Не удалось поменять правильно данные");
    }

    @Test
    @Step("Проверка Display name")
    @Order(6)
    public void testCheckDisplayName(){
        Assertions.assertTrue(registrationForm.checkDisplayName(), "DisplayName не совпадает.");
    }

    @Test
    @Step("Проверка DOB")
    @Order(7)
    public void testCheckDOB(){
        Assertions.assertTrue(registrationForm.checkDOB(), "DOB не совпадает.");
    }
}
