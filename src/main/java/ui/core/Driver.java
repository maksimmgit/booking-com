package ui.core;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class Driver {


    public static void getDriver(){
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("chromeoptions.args", "-incognito");
        System.setProperty("chromeoptions.args", "--disable-blink-features=AutomationControlled");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout=60000;
        open("https://www.booking.com/index.ru.html");
        //$x("//button[@data-modal-id=\"language-selection\"]").click();
        //$x("//div[@lang='ru']").click();
        executeJavaScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");


    }

    public static void closeDriver(){
        closeWebDriver();
    }
}
