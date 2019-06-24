package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.page.AbstractPageComponent;
import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;

public class CategoryPage extends AbstractPageComponent {

    private static final By CATEGORIES_PAGE_ROOT = By.id("page_main");

    private static final String SUB_CATEGORY = ".a_category[title*='%s']";

    CategoryPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        waitForPageComponentElementVisible(CATEGORIES_PAGE_ROOT);
    }

    private WebElement getRootElement() {
        return getElement(CATEGORIES_PAGE_ROOT);
    }

    public ActionPromise openSubCategory(String subCategory) {
        getRootElement().findElement(cssSelector(format(SUB_CATEGORY, subCategory))).click();
        return new ActionPromise(getContext());
    }
}
