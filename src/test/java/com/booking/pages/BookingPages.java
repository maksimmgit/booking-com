package com.booking.pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BookingPages {

    private final SelenideElement ACCEPT_COOKIES = $x("//button[@id='onetrust-accept-btn-handler']");

    //смена валюты
    private final SelenideElement CURRENCY_BUTTON = $x("//button[@data-modal-header-async-type=\"currencyDesktop\"]");
    private final SelenideElement USD_CURRENCY_BUTTON = $x("//div[@class='bui-traveller-header__currency'][contains(text(),'USD')]");
    private final SelenideElement USD_CURRENCY_BUTTON_CHECK = $x("//button[@data-modal-header-async-type=\"currencyDesktop\"]/span/span[contains(text(),'USD')]");

    //поле ввода направления
    private final SelenideElement INPUT_DESTINATION = $x("//input[@id='ss']");

    //поле выбора дат
    private final SelenideElement CHOOSE_DATES = $x("//div[@class='xp__dates xp__group']");
    //кнопка next в календаре
    private final SelenideElement NEXT_BUTTON = $x("//div[@class='bui-calendar__control bui-calendar__control--next']/*");
    //04/12
    private final SelenideElement FOURTH_OF_DEC = $x("//td[@data-date='2021-12-04']");
    //11/12
    private final SelenideElement ELEVENTH_OF_DEC = $x("//td[@data-date='2021-12-11']");

    //поле выбора взрослых и детей
    private final SelenideElement CHOOSE_PEOPLE = $x("//div[@class='xp__input-group xp__guests']");
    //+ children
    private final SelenideElement CHILDREN_ADD = $x("//button[@class='bui-button bui-button--secondary bui-stepper__add-button '][@aria-describedby='group_children_desc']");
    //children_age_field
    private final SelenideElement CHILD_AGE_FIELD = $x("//select[@name='age']");
    //age check

    //кнопка поиска
    private final SelenideElement SEARCH_BUTTON = $x("//button[@class='sb-searchbox__button ']");


    //5 st hotel checkbox
    private final SelenideElement HOTEL_STARS_CHECKBOX = $x("//div[@class='bui-checkbox__label filter_item css-checkbox']/span[contains(text(),'5 з')]");
    private final ElementsCollection HOTEL_STARS_CHECKER = $$x("//div[@data-class]");
    private final SelenideElement HOTEL_WAIT_ELEMENT = $("div[id='filter_filter-suggestions'] a[class='filterelement js-filter__element active'] div[class='bui-checkbox__label filter_item css-checkbox ']");



    public boolean switchCurrency(){
        CURRENCY_BUTTON.click();
        USD_CURRENCY_BUTTON.click();
        return USD_CURRENCY_BUTTON_CHECK.is(Condition.exist);
    }

    //здесь ловим выпадающее меню с нужным параметром, ждём его и кликаем.
    //При случае переделать с %s, чтобы была красивая строка
    public boolean chooseDestination(String query, String matches){

        ACCEPT_COOKIES.shouldBe(Condition.visible).click();
        INPUT_DESTINATION.click();
        INPUT_DESTINATION.setValue(query);
        SelenideElement chooseMenu = $x("//li[@data-label=\"" + matches+  "\"]");
        chooseMenu.shouldBe(Condition.exist);
        chooseMenu.click();
        return INPUT_DESTINATION.is(Condition.value("Breuil-Cervinia, Valle d'Aosta, Italy"));
    }


    public boolean chooseDates(){
        CHOOSE_DATES.hover();
        Selenide.actions().moveToElement(CHOOSE_DATES).clickAndHold().pause(Duration.ofSeconds(1)).release().perform();
        NEXT_BUTTON.shouldBe(Condition.exist);
        CHOOSE_DATES.click();

        NEXT_BUTTON.click();
        NEXT_BUTTON.click();
        FOURTH_OF_DEC.shouldBe(Condition.exist).click();
        ELEVENTH_OF_DEC.shouldBe(Condition.exist).click();
        boolean result = false;
        if(($(byText("сб, 4 дек.")).is(Condition.exist)) && ($(byText("сб, 11 дек.")).is(Condition.exist))){
            result = true;
        }
        return result;
    }


    public boolean chooseGuestAmount(int pressDown){
        CHOOSE_PEOPLE.click();
        CHILDREN_ADD.click();
        CHILD_AGE_FIELD.click();
        for (int i = 0; i < pressDown+1; i++) {
            CHILD_AGE_FIELD.sendKeys(Keys.ARROW_DOWN);
        }
        CHILD_AGE_FIELD.pressEnter();
        SelenideElement childAgeCheck = $x("//select[@name='age']//option[@value='" + pressDown + "']");
        return childAgeCheck.is(Condition.attribute("selected"));
    }

    public boolean clickToTheSearchButton(){
        SEARCH_BUTTON.click();
        SelenideElement confirmText = $x("//h2[contains(text(), 'Брёй-Червиния: найдено ')]");
        return confirmText.is(Condition.exist);

    }

    public boolean chooseAFiveStarHotel(String stars){
        HOTEL_STARS_CHECKBOX.scrollIntoView(true);
        HOTEL_STARS_CHECKBOX.click();
        $("div[class='sr-usp-overlay__message'] div:nth-child(2)").shouldNotBe(Condition.visible);
        //HOTEL_WAIT_ELEMENT.shouldBe(Condition.exist);
        boolean result = true;
        for (SelenideElement e: HOTEL_STARS_CHECKER) {
            if(!(Objects.equals(e.getAttribute("data-class"), stars))){
                result = false;
                System.out.println("================================================");
                System.out.println("result false");
            }
        }
        return result;
    }


}
