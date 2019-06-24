package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.selenium.TestContext;

public class ActionPromise {

    TestContext context;

    ActionPromise(TestContext context) {
        this.context = context;
    }

    public CategoryPage andGetCategoryPage(TestContext context) {
        return new CategoryPage(context);
    }

    public FilterPage andGetFilterPage(TestContext context) {
        return new FilterPage(context);
    }

    public AlertPopup andGetAlertPopup(TestContext context) {
        return new AlertPopup(context);
    }

    public FavoritesPage andGetFavoritesPage(TestContext context) {
        return new FavoritesPage(context);
    }

    public ApplicationHeaderPage andGetApplicationHeader(TestContext context) {
        return new ApplicationHeaderPage(context);
    }
}
