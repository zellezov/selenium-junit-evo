package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.page.AbstractPageComponent;
import com.evoselenium.framework.selenium.TestContext;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FavoritesPage extends AbstractPageComponent {

    private static final By FAVORITES_PAGE_ROOT = By.cssSelector(".page_header");

    FavoritesPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        assertThat(new ApplicationHeaderPage(getContext()).getActiveMenuItem().contains("favorites"), is(true));
        waitForPageComponentElementVisible(FAVORITES_PAGE_ROOT);
    }
}
