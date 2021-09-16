package ui.core;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Driver {


    public static void getDriver(){
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://booking.com");
        Configuration.pageLoadStrategy = "none";
        Configuration.timeout = 50;
    }


    public static void closeDriver(){
        closeWebDriver();
    }
}
