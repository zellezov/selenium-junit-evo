package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.page.AbstractPageComponent;
import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationHeaderPage extends AbstractPageComponent {

    private static final By APPLICATION_HEADER_ROOT = By.id("main_table");

    private static final By ACTIVE_MENU_ITEM = By.cssSelector(".a_menu_active");

    private static final By SEARCH = By.cssSelector("a[href$='/search/']");

    private static final By FAVORITES = By.cssSelector("a[href$='/favorites/']");

    public ApplicationHeaderPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        waitForPageComponentElementVisible(APPLICATION_HEADER_ROOT);
    }

    private WebElement getRootElement() {
        return getElement(APPLICATION_HEADER_ROOT);
    }

    String getActiveMenuItem() {
        return getRootElement().findElement(ACTIVE_MENU_ITEM).getAttribute("href");
    }

    public SearchPage openSearch() {
        getRootElement().findElement(SEARCH).click();
        return new SearchPage(getContext());
    }

    public FavoritesPage openFavorites() {
        getRootElement().findElement(FAVORITES).click();
        return new FavoritesPage(getContext());
    }
}
