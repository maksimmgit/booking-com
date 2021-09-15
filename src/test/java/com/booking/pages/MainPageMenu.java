package com.booking.pages;


import com.booking.ui.TestTopMenuLinks;
import ui.core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageMenu {

    /*
    Ссылки из верхнего меню для верификации и проклика.
     */
    //жильё
    public static final By STAYS_LINK_INACTIVE = By.cssSelector("li:nth-child(1) a:nth-child(1) span:nth-child(2)");
    public static final By STAYS_CSS_LINK_ACTIVE = By.cssSelector("a[class='bui-tab__link bui-tab__link--selected'] span[class='bui-tab__text']");
    //перелёты
    public static final By FLIGHTS_CSS_LINK_INACTIVE = By.cssSelector("header[class='bui-header bui-header--logo-large bui-u-hidden-print '] li:nth-child(2) a:nth-child(1) span:nth-child(2)");
    public static final By FLIGHTS_CSS_LINK_ACTIVE = By.cssSelector("a[class='Actionable-module__root___1Be0F Tab-module__link___3Etkm Tab-module__link--selected___bTkCG'] span[class='Tab-module__text___2vXbZ']");
    //аренда автомобилей
    public static final By CAR_RENTAL_CSS_INACTIVE = By.cssSelector("li:nth-child(3) a:nth-child(1) span:nth-child(2)");
    public static final By CAR_RENTAL_CSS_ACTIVE = By.cssSelector(".bui-tab__link.bui-tab__link--selected");
    //аттракционы
    public static final By ATTRACTIONS_CSS_INACTIVE = By.cssSelector("li:nth-child(5) a:nth-child(1) span:nth-child(2)");
    public static final By ACCRACTIONS_CSS_ACTIVE = By.cssSelector("a[class='Actionable-module__root___3GRl0 Tab-module__link___vI35C Tab-module__link--selected___3qmZH'] span[class='Tab-module__text___3vSL-'] span");
    //такси
    private static final By AIRPORT_CSS_TAXIS_INACTIVE = By.cssSelector("li:nth-child(2) a:nth-child(1) span:nth-child(2) span:nth-child(1)");
    private static final By AIRPORT_CSS_TAXIS_ACTIVE = By.cssSelector(".bui-tab__link.bui-tab__link--selected");
    //перелёт+отель
    private static final By FLIGHT_AND_HOTEL_CSS_INACTIVE = By.cssSelector("body > header:nth-child(3) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
    private static final By FLIGHT_AND_HOTEL_CSS_ACTIVE = By.xpath("//title[contains(text(), \"Booking.com powered by lastminute.com\")]");


    public boolean clickAndVerify(By linkToClick, By verificationLocator){
        WebElement toClick = TestTopMenuLinks.driver.findElement(linkToClick);
        toClick.click();
        WebElement toVerify = TestTopMenuLinks.driver.findElement(verificationLocator);
        boolean visible = false;
        if(toVerify.isDisplayed()){
            visible =  true;
        }
        return visible;
    }
}
