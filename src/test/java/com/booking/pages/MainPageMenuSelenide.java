package com.booking.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class MainPageMenuSelenide {


    public boolean clickAndVerify(SelenideElement linkToClick, SelenideElement verificationLocator){
        boolean visible = false;
        (linkToClick).click();
        if(verificationLocator.is(Condition.exist)){
            visible = true;
        }
        return visible;
    }
}
