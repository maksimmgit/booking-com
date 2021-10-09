package ui.core;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Driver {


    public static void getDriver(){
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("chromeoptions.args", "-incognito");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout=10000;
        open("https://booking.com");


    }

    public static void closeDriver(){
        closeWebDriver();
    }
}
