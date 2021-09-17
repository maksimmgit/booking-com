package com.booking.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.Driver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;


public class MainPageMenuSelenide {


    public boolean clickAndVerify(SelenideElement linkToClick, SelenideElement verificationLocator){
        boolean visible = false;
        linkToClick.click();
        if(verificationLocator.is(Condition.exist)){
            visible = true;
        }
        return visible;
    }
}
