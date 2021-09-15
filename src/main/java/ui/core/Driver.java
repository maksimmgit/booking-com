package ui.core;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final Integer DEFAULT_SECONDS_WAIT = 10;
    public static WebDriver driver;

    @BeforeClass
    public static void getDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DEFAULT_SECONDS_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeDriver(){
        driver.close();
    }
}
