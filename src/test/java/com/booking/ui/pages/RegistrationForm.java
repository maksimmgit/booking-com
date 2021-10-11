package com.booking.ui.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    //линк на страницу регистрации
    private final SelenideElement REGISTER_LINK = $x("//span[contains(text(),'Зарегистрироваться')]");
    //проверочное поле страницы регистрации, она же submit button
    private final SelenideElement REGISTER_PAGE_CONFIRMATOR = $x("//span[contains(text(),'Продолжить через электронную почту')]");
    //форма ввода мыла
    private final SelenideElement EMAIL_INPUT_FORM = $x("//input[@id='username']");
    private final SelenideElement EMAIL_ERROR_MESSAGE = $x("//div[@id='username-note' and text()=\"Проверьте правильность ввода.\"]");
    //кнопка продолжить при вводе мыла
    private final SelenideElement EMAIL_BUTTON_SUBMIT = $x("//button[@type=\"submit\"]");
    private final SelenideElement INPUT_ID_PASSWORD = $x("//input[@id='password']");

    //страница ввода пароля
    private final SelenideElement PASSWORD_PAGE_CONFIRMATIOR = $x("//*[text()='Введите пароль | Booking.com']");
    //поле ввода пароля
    private final SelenideElement NEW_PASSWORD_FORM = $x("//input[@id='new_password']");
    private final SelenideElement NEW_PASSWORD_CONFIRMATION = $x("//input[@id='confirmed_password']");
    //кнопка submit
    private final SelenideElement CREATE_ACCOUNT_BUTTON = $x("//button[@type='submit']");
    //всплывающий фрейм
    private final SelenideElement MAIN_PAGE_FRAME = $x("//button[@class='bui-button bui-button--wide bui-button--large']/span[@class='bui-button__text']");
    //personal profile page
    private final SelenideElement MAIN_PAGE_LOGGED_IN = $x("//span[@id='profile-menu-trigger--title']");
    //управлять аккаунтом
    private final SelenideElement EDIT_ACCOUNT_LINK = $x("//span[contains(text(),'Управлять аккаунтом')]");
    //Personal details link
    private final SelenideElement PERSONAL_DETAILS_LINK = $x("//div[@id='personaldetails_title']");
    //Personal details page
    private final SelenideElement PERSONAL_DETAILS_PAGE = $x("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    //edit title
    private final SelenideElement EDIT_TITLE = $x("//button[@data-ga-label=\"Edit section: title\"]");
    //choose
    private final SelenideElement CHOOSE_TITLE = $x("//select[@name=\"title\"]");
    //Select Mrs.
    private final SelenideElement SELECT_TITLE_MRS = $x("//select[@name=\"title\"]/option[4]");
    //Save Title
    private final SelenideElement SAVE_TITLE = $x("//button[@data-ga-label='Save section: title']");
    //Edit Name link
    private final SelenideElement EDIT_NAME_LINK = $x("//body/div[@id='root']/div[contains(@class,'my-settings-outer-container')]/div[@class='my-settings-app-container']/div[@class='my-settings-main-container']/div[@class='my-settings-flex-by-row']/div[@class='my-settings-flex-grow']/div[@class='my-settings-page']/div[contains(@class,'my-settings-edit-table bui-f-font-featured')]/div[2]/div[1]/div[1]/button[1]/span[1]");
    //put name field
    private final SelenideElement INPUT_FIRST_NAME = $x("(//div[@class='bui-input-text__field'])[1]");
    //input last name
    private final SelenideElement INPUT_LAST_NAME = $x("(//div[@class='bui-input-text__field'])[2]");
    //edit display name
    private final SelenideElement EDIT_DISPLAY_NAME = $x("//button[@data-ga-label=\"Edit section: nickname\"]");
    //DisplayName
    private final SelenideElement INPUT_DISPLAY_NAME = $x("//input[@placeholder='Choose a display name']");
    //Save DisplayName
    private final SelenideElement SAVE_DISPLAY_NAME = $x("//button[@data-ga-label=\"Save section: nickname\"]");
    //check green tick
    private final SelenideElement CHECK_GREEN_TICK1 = $x("//form[@id='e7312297-5ed4-4671-8927-f98c99724c89_form']//span[@class='_1DYeoLTBFL3S4-b0JE_GoR _3hO12_mL-ixNGax_nPmmIk _3uvTQ3gI3pHetzVoxv8kYN']//*[name()='svg']");
    private final SelenideElement CHECK_GREEN_TICK_CSS = $("body.ltr:nth-child(2) div.bui-u-text-left.bui_font_body:nth-child(6) div.my-settings-outer-container div.my-settings-app-container div.my-settings-main-container div.my-settings-flex-by-row div.my-settings-flex-grow div.my-settings-page div.my-settings-edit-table.bui-f-font-featured div.my-settings-row.my-settings-edit-row--editing:nth-child(3) div.my-settings-row div.my-settings-edit-row div.my-settings-col-grow.my-settings-cell-spacing div.my-settings-flex-by-row.my-settings-flex-by-row--reverse div.my-settings-flex-grow div.my-settings-edit-mode form.my-settings-edit-row-form div.bui-form__group div.bui-input-text__content div.bui-input-text__field div.bui-input-text__side > span.bui-icon.bui-icon--small.bui-icon--color-constructive");

    //edit dateOfBirth
    private final SelenideElement EDIT_DOB = $x("//button[@data-ga-label=\"Edit section: date_of_birth\"]");
    //edit dob_disabled button
    private final SelenideElement EDIT_DOB_DISABLED = $x("//button[@data-ga-label=\"Edit section: date_of_birth\"][@disabled]");
    //Day
    private final SelenideElement INPUT_DD = $x("//input[@placeholder=\"DD\"]");
    //Month
    private final SelenideElement INPUT_MM = $x("//input[@placeholder=\"MM\"]");
    //year
    private final SelenideElement INPUT_YYYY = $x("//input[@placeholder=\"YYYY\"]");
    //save dob
    private final SelenideElement SAVE_DOB = $x("//button[@type='submit']");


    /*
    Values to check
     */
    String nameCheck="";
    private final SelenideElement TITLE_CHECK = $x("//div[@class='my-settings-display-mode']/div[contains(text(), \"Mrs.\")]");
    private final SelenideElement DISPLAY_NAME_CHECK = $x("//div[@class='my-settings-display-mode']/div[contains(text(), \""+nameCheck+"\")]");
    private final SelenideElement EMAIL_CHECK = $x("//div[@class='my-settings-no-wrap']/div[contains(text(), \"testqa100101@yandex.ru\")]");
    private final SelenideElement DOB_CHECK = $x("//div[contains(text(),'24/12/1945')]");
    private final SelenideElement H1_TO_CLICK = $x("//h1[normalize-space()='Personal details']");



    public boolean moveToEmailPage(){
        //sleep(10000);
        REGISTER_LINK.click();
        return REGISTER_PAGE_CONFIRMATOR.is(Condition.exist);
    }

    public boolean inputWrongEmail(String s){
        EMAIL_INPUT_FORM.click();
        EMAIL_INPUT_FORM.setValue(s).pressEnter();
        boolean result = false;
        if(EMAIL_ERROR_MESSAGE.is(not(Condition.exist)) || INPUT_ID_PASSWORD.is(Condition.exist)){
            result = true;
        }
        refresh();
        EMAIL_ERROR_MESSAGE.shouldNotBe(exist);
        return result;
    }


    public boolean inputCorrectEmail(String s){
        sleep(1000);
        EMAIL_INPUT_FORM.click();
        EMAIL_INPUT_FORM.setValue(s);
        sleep(1000);
        EMAIL_INPUT_FORM.pressEnter();
        //EMAIL_BUTTON_SUBMIT.click();
        boolean result = false;
        if(PASSWORD_PAGE_CONFIRMATIOR.is(not(Condition.exist))){
            result = true;
        }
        return result;
    }

    public boolean inputCorrectPassword(String s) {
        sleep(1000);
        NEW_PASSWORD_FORM.click();
        NEW_PASSWORD_FORM.setValue(s);
        sleep(1000);
        NEW_PASSWORD_CONFIRMATION.click();
        NEW_PASSWORD_CONFIRMATION.setValue(s);
        sleep(1000);
        //CREATE_ACCOUNT_BUTTON.click();
        Selenide.actions().moveToElement(CREATE_ACCOUNT_BUTTON)
                .clickAndHold()
                .pause(Duration.ofSeconds(35))
                .release()
                .perform();

        MAIN_PAGE_FRAME.shouldBe(visible);
        if(MAIN_PAGE_FRAME.is(visible)){
            MAIN_PAGE_FRAME.click();
        }
        boolean result = false;
        if(MAIN_PAGE_LOGGED_IN.is(Condition.exist)){
            result = true;
        }
        return result;
    }


    public boolean navigateToPersonalProfile(){
        MAIN_PAGE_LOGGED_IN.click();
        EDIT_ACCOUNT_LINK.click();
        PERSONAL_DETAILS_LINK.click();
        boolean result = false;
        if(PERSONAL_DETAILS_PAGE.is(Condition.exist)){
            result = true;
        }
        return result;
    }

    public void editPersonalDetails(String displayName, String DD, String MM, String YYYY){
        nameCheck = displayName;

        EDIT_TITLE.click();
        CHOOSE_TITLE.click();
        CHOOSE_TITLE.sendKeys(Keys.DOWN);
        CHOOSE_TITLE.sendKeys(Keys.DOWN);
        CHOOSE_TITLE.sendKeys(Keys.DOWN);
        CHOOSE_TITLE.pressEnter();
        SAVE_TITLE.click();


        //System.out.println("getAttribute = " + EDIT_DISPLAY_NAME.getAttribute("aria-disabled"));
        EDIT_DISPLAY_NAME.shouldBe(Condition.attribute("aria-disabled","false"));
        EDIT_DISPLAY_NAME.click();
        INPUT_DISPLAY_NAME.click();
        INPUT_DISPLAY_NAME.setValue(displayName);
        SAVE_DISPLAY_NAME.click();
        //CHECK_GREEN_TICK_CSS.shouldBe(appear);
        //CHECK_GREEN_TICK1.shouldBe(appear);
        Selenide.actions()
                .moveToElement(SAVE_DISPLAY_NAME)
                .clickAndHold()
                .pause(Duration.ofSeconds(10))
                .release()
                .perform();



        EDIT_DOB_DISABLED.shouldNotBe(exist);
/*        Selenide.actions()
                .moveToElement(EDIT_DOB_DISABLED)
                .clickAndHold()
                .pause(Duration.ofSeconds(5))
                .click()
                .perform();*/
        EDIT_DOB.click();
        INPUT_DD.click();
        INPUT_DD.setValue(DD);
        INPUT_MM.setValue(MM);
        INPUT_YYYY.setValue(YYYY);
        Selenide.actions()
                .moveToElement(SAVE_DOB)
                .clickAndHold()
                .pause(Duration.ofSeconds(5))
                .release()
                .perform();
    }

    public boolean checkTitle(){
        boolean result = false;
        DOB_CHECK.shouldBe(visible);
        if(TITLE_CHECK.is(Condition.exist)){
            result = true;
        }
        return result;
    }

    public boolean checkDisplayName(){
        boolean result = false;
        DOB_CHECK.shouldBe(visible);
        if(DISPLAY_NAME_CHECK.is(Condition.exist)){
            result = true;
        }
        return result;
    }

    public boolean checkDOB(){
        boolean result = false;
        DOB_CHECK.shouldBe(visible);
        if(DOB_CHECK.is(Condition.exist)){
            result = true;
        }
        return result;
    }

}
