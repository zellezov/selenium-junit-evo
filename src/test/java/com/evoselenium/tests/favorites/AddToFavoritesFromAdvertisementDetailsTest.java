package com.evoselenium.tests.favorites;

import com.evoselenium.framework.page.ui.advertisement.AdvertisementRow;
import com.evoselenium.framework.page.ui.categories.CategoriesPage;
import com.evoselenium.framework.selenium.SeleniumTestFramework;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.evoselenium.framework.page.ui.categories.Category.TRANSPORT;

public class AddToFavoritesFromAdvertisementDetailsTest extends SeleniumTestFramework {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddToFavoritesFromAdvertisementDetailsTest.class.getName());

    /**
     * Test description:
     * Verify that it is possible to add advertisement to favorites from advertisement details page.
     * <p>
     * Test steps:
     * 1. Go to 'Categories' page
     * 2. Open category 'Transport'
     * 3. Open sub-category 'Cars'
     * 4. Select make 'Volvo' and get first advertisement in list
     * 5. Capture advertisement wording and open details
     * 6. Click 'Add to favorites' and get alert popup
     * 7. Click 'OK' and open 'Favorites' page
     * 8. Verify that advertisement is present in favorites
     */
    @Test
    public void testAddToFavoritesFromAdvertisementDetails() {

        LOGGER.info("1. Open advertisement category 'Transport > Cars > Volvo'");
        AdvertisementRow advertisement = new CategoriesPage(getContext())
                .openCategory(TRANSPORT)
                .andGetCategoryPage(getContext())
                .openSubCategory("Cars")
                .andGetCategoryPage(getContext())
                .openSubCategory("Volvo")
                .andGetFilterPage(getContext())
                .getAdvertisementByIndex(0);

        LOGGER.info("2. Capture wording of first advertisement in list");
        String wording = advertisement.getWording();

        LOGGER.info("3. Add advertisement to favorites and verify it has been successfully added");
        advertisement.openDetails()
                .clickAddToFavorites()
                .andGetAlertPopup(getContext())
                .clickOk()
                .andGetApplicationHeader(getContext())
                .openFavorites()
                .getAdvertisementGroupByCategory("Volvo")
                .verifyAdvertisementPresentByWording(wording);
    }
}
