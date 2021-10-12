package com.booking.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageLanguages {

    //кнопка выбора языка
    private final SelenideElement LANGUAGE_SELECTION = $x("//button[@data-modal-id='language-selection']");

    //кнопки языков
    private final SelenideElement EN_GB = $x("//div[@lang='en-gb']");
    private final SelenideElement EN_US = $x("//div[@lang='en-us']");
    private final SelenideElement DE = $x("//div[@lang='de']");
    private final SelenideElement IT = $x("//div[@lang='it']");
    private final SelenideElement PL = $x("//div[@lang='pl']");

    //подтверждающие ссылки
    private final SelenideElement EN_GB_CHECK = $x("//link[@href='https://www.booking.com/index.en-gb.html'][@rel='canonical']");
    private final SelenideElement EN_US_CHECK = $x("//span[contains(text(),'Your current language is English (US)')]");
    private final SelenideElement DE_CHECK = $x("//span[contains(text(),'Ihre aktuelle Sprache ist Deutsch')]");
    private final SelenideElement IT_CHECK = $x("//span[contains(text(),'Lingua attuale: Italiano')]");
    private final SelenideElement PL_CHECK = $x("//span[contains(text(),'Wybrany język to Polski')]");

    public boolean switchToGBCheck(){
        LANGUAGE_SELECTION.click();
        EN_GB.click();
        return EN_GB_CHECK.is(Condition.exist);
    }

    public boolean switchToUSCheck(){
        LANGUAGE_SELECTION.click();
        EN_US.click();
        return EN_US_CHECK.is(Condition.exist);
    }

    public boolean switchToDECheck(){
        LANGUAGE_SELECTION.click();
        DE.click();
        return DE_CHECK.is(Condition.exist);
    }

    public boolean switchToITCheck(){
        LANGUAGE_SELECTION.click();
        IT.click();
        return IT_CHECK.is(Condition.exist);
    }

    public boolean switchToPLCheck(){
        LANGUAGE_SELECTION.click();
        PL.click();
        return PL_CHECK.is(Condition.exist);
    }

}
