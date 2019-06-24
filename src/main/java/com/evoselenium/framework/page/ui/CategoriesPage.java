package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.page.AbstractPageComponent;
import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;

public class CategoriesPage extends AbstractPageComponent {

    private static final By CATEGORIES_PAGE_ROOT = By.id("page_main_full");

    private static final String CATEGORY = ".main_head2 .a1[title*='%s']";

    public CategoriesPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        waitForPageComponentElementVisible(CATEGORIES_PAGE_ROOT);
    }

    private WebElement getRootElement() {
        return getElement(CATEGORIES_PAGE_ROOT);
    }

    public ActionPromise openCategory(String category) {
        getRootElement().findElement(cssSelector(format(CATEGORY, category))).click();
        return new ActionPromise(getContext());
    }

    public ActionPromise openSubCategory(String category, String subCategory) {

        return new ActionPromise(getContext());
    }
}
