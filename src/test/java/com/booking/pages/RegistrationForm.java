package com.booking.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

public class RegistrationForm {

    //линк на страницу регистрации
    private final SelenideElement REGISTER_LINK = $x("//span[contains(text(),'Зарегистрироваться')]");
    //проверочное поле страницы регистрации, она же submit button
    private final SelenideElement REGISTER_PAGE_CONFIRMATOR = $x("//span[contains(text(),'Продолжить через электронную почту')]");
    //форма ввода мыла
    private final SelenideElement EMAIL_INPUT_FORM = $x("//input[@id='username']");
    private final SelenideElement EMAIL_ERROR_MESSAGE = $x("//div[@id='username-description' and text()=\"Проверьте правильность ввода.\"]");
    private final SelenideElement INPUT_ID_PASSWORD = $x("//input[@id='password']");



    public boolean moveToEmailPage(){
        REGISTER_LINK.click();
        return REGISTER_PAGE_CONFIRMATOR.is(Condition.exist);
    }

    public boolean inputWrongEmail(String s){
        System.out.println("s = " + s);
        EMAIL_INPUT_FORM.click();
        EMAIL_INPUT_FORM.setValue(s).pressEnter();
        boolean result = false;
        if(EMAIL_ERROR_MESSAGE.is(not(Condition.exist)) || INPUT_ID_PASSWORD.is(Condition.exist)){
            result = true;
        }
        return result;
    }
}
