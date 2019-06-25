package com.evoselenium.tests.favorites;

import com.evoselenium.framework.page.ui.categories.CategoriesPage;
import com.evoselenium.framework.page.ui.results.FilterPage;
import com.evoselenium.framework.selenium.SeleniumTestFramework;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.evoselenium.framework.page.ui.categories.Category.ENTERTAINMENT;

public class AddListToFavoritesFromFilterResultsTest extends SeleniumTestFramework {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddListToFavoritesFromFilterResultsTest.class.getName());

    /**
     * Test description:
     * Verify that it is possible to add list of advertisements to favorites from advertisement list page.
     * <p>
     * Test steps:
     * 1. Open advertisement category 'Entertainment > Music, instrument, education > El. guitars'
     * 2. Capture wording of first, third and fifth advertisement in list and select them
     * 3. Add advertisements to favorites and verify they have been successfully added
     */
    @Test
    public void testAddListToFavoritesFromFilterResults() {

        LOGGER.info("1. Open advertisement category 'Entertainment > Music, instrument, education > El. guitars'");
        FilterPage entertainment = new CategoriesPage(getContext())
                .openSubCategory(ENTERTAINMENT, "Music, instrument, education")
                .andGetCategoryPage(getContext())
                .openSubCategory("El. guitars")
                .andGetFilterPage(getContext());

        LOGGER.info("2. Capture wording of first, third and fifth advertisement in list and select them");
        String guitarsWordingFirst = entertainment.getAdvertisementByIndex(0).select().getWording();
        String guitarsWordingThird = entertainment.getAdvertisementByIndex(2).select().getWording();
        String guitarsWordingFifth = entertainment.getAdvertisementByIndex(4).select().getWording();

        LOGGER.info("3. Add advertisements to favorites and verify they have been successfully added");
        entertainment.clickAddToFavorites()
                .andGetAlertPopup(getContext())
                .clickOk()
                .andGetApplicationHeader(getContext())
                .openFavorites()
                .getAdvertisementGroupByCategory("El. guitars")
                .verifyAdvertisementPresentByWording(guitarsWordingFirst)
                .verifyAdvertisementPresentByWording(guitarsWordingThird)
                .verifyAdvertisementPresentByWording(guitarsWordingFifth);
    }
}
