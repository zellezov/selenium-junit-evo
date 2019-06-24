package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdvertisementRow {

    private static final By SELECT = By.cssSelector(".msga2.pp0 input");

    private static final By WORDING = By.cssSelector(".msg2 .d1 .am");

    private WebElement rootElement;

    private TestContext context;

    AdvertisementRow(WebElement rootElement, TestContext context) {
        this.rootElement = rootElement;
        this.context = context;
    }

    public void select() { //todo getState? unselect? toggleSelect?
        rootElement.findElement(SELECT).click();
    }

    public String getWording() {
        return rootElement.findElement(WORDING).getText();
    }

    public AdvertisementPage openAdvertisement() {
        rootElement.findElement(WORDING).click();
        return new AdvertisementPage(context);
    }

}
