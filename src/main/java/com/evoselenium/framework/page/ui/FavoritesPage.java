package com.evoselenium.framework.page.ui;

import com.evoselenium.framework.selenium.TestContext;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FavoritesPage extends FilterPage {

    FavoritesPage(TestContext context) {
        super(context);
    }

    @Override
    public void verify() {
        assertThat(new ApplicationHeaderPage(getContext()).getActiveMenuItem().contains("favorites"), is(true));
        waitForPageComponentElementVisible(FILTER_PAGE_ROOT);
    }

    private List<AdvertisementGroup> getAdvertisementGroups() {
        return getRootElement().findElements(FILTER_RESULTS)
                .stream()
                .map(element -> new AdvertisementGroup(element, getContext()))
                .collect(Collectors.toList());
    }

    public AdvertisementGroup getAdvertisementGroupByCategory(String category) {
        return getAdvertisementGroups().stream()
                .filter(group -> group.getCategory().contains(category))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Unable to find group by category: '" + category + "'"));
    }

    public FavoritesPage verifyAdvertisementPresentInCategory(String category, String wording) {
        getAdvertisementGroupByCategory(category).verifyAdvertisementPresentByWording(wording);
        return this;
    }
}
