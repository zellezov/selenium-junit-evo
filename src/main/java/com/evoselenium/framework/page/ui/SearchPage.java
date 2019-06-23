package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.page.AbstractPageComponent;
import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;

public class SearchPage extends AbstractPageComponent {

    private static final By SEARCH_PAGE_ROOT = By.cssSelector("form[action$='/search-result/']");

    SearchPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        waitForPageComponentElementVisible(SEARCH_PAGE_ROOT);
    }
}
