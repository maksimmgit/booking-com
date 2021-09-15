package com.booking.ui;

import com.booking.pages.MainPageMenu;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTopMenuLinks {
    private static final Integer DEFAULT_SECONDS_WAIT = 10;
    public static WebDriver driver;


    @BeforeClass
    public static void getDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {

            //driver.manage().timeouts().implicitlyWait(DEFAULT_SECONDS_WAIT, TimeUnit.SECONDS);

            driver.get("https://booking.com");
        } catch (TimeoutException ignore) {
        }
    }

    @AfterClass
    public static void closeDriver(){
        driver.close();
    }


    /*
    Ссылки из верхнего меню для верификации и проклика.
    */
    //жильё
    public static final By STAYS_LINK_INACTIVE = By.cssSelector("li:nth-child(1) a:nth-child(1) span:nth-child(2)");
    public static final By STAYS_CSS_LINK_ACTIVE = By.cssSelector("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //перелёты
    public static final By FLIGHTS_CSS_LINK_INACTIVE = By.cssSelector("body > header:nth-child(4) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)");
    public static final By FLIGHTS_CSS_LINK_ACTIVE = By.cssSelector("a[class='Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG'] span[class='Tab-module__text___2vXbZ']");
    //аренда автомобилей
    public static final By CAR_RENTAL_CSS_INACTIVE = By.cssSelector("header[class='bui-header bui-header--logo-large bui-u-hidden-print '] li:nth-child(4) a:nth-child(1) span:nth-child(2)");
    public static final By CAR_RENTAL_CSS_ACTIVE = By.cssSelector("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //аттракционы
    public static final By ATTRACTIONS_CSS_INACTIVE = By.cssSelector("li:nth-child(5) a:nth-child(1) span:nth-child(2)");
    public static final By ATTRACTIONS_CSS_ACTIVE = By.cssSelector("a[class='Actionable-module__root___3GRl0 Tab-module__link___vI35C Tab-module__link--selected___3qmZH'] span[class='Tab-module__text___3vSL-'] span");
    //такси
    private static final By AIRPORT_CSS_TAXIS_INACTIVE = By.cssSelector("li:nth-child(6) a:nth-child(1) span:nth-child(2) span:nth-child(1)");
    private static final By AIRPORT_CSS_TAXIS_ACTIVE = By.cssSelector("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //перелёт+отель
    private static final By FLIGHT_AND_HOTEL_CSS_INACTIVE = By.cssSelector("body > header:nth-child(3) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    private static final By FLIGHT_AND_HOTEL_CSS_ACTIVE = By.xpath("//title[contains(text(), \"Booking.com powered by lastminute.com\")]");




    @Test
    @DisplayName("Авиабилеты")
    public void test1FlightsTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(FLIGHTS_CSS_LINK_INACTIVE, FLIGHTS_CSS_LINK_ACTIVE));
    }

    @Test
    @DisplayName("Жильё")
    public void test2StaysTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(STAYS_LINK_INACTIVE, STAYS_CSS_LINK_ACTIVE));
    }

    @Test
    @DisplayName("Аренда автомобилей")
    public void test3CarRentalTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(CAR_RENTAL_CSS_INACTIVE, CAR_RENTAL_CSS_ACTIVE));
    }

    @Test
    @DisplayName("Варианты досуга")
    public void test4AttractionsTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(ATTRACTIONS_CSS_INACTIVE, ATTRACTIONS_CSS_ACTIVE));
    }

    @Test
    @DisplayName("Такси от/до аэропорта")
    public void test5AirportTaxisTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(AIRPORT_CSS_TAXIS_INACTIVE, AIRPORT_CSS_TAXIS_ACTIVE));
    }

    @Test
    @DisplayName("Перелёт и отель")
    public void test6FlightAndHotelTest(){
        MainPageMenu mainPageMenu = new MainPageMenu();
        Assert.assertTrue("CSS локатор не соответствует.", mainPageMenu.clickAndVerify(FLIGHT_AND_HOTEL_CSS_INACTIVE, FLIGHT_AND_HOTEL_CSS_ACTIVE));
    }


}
