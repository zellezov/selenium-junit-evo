package com.evoselenium.tests;

import com.evoselenium.framework.page.ui.*;
import com.evoselenium.framework.selenium.SeleniumTestFramework;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prototype extends SeleniumTestFramework {

    private static final Logger LOGGER = LoggerFactory.getLogger(Prototype.class.getName());

    @Test
    public void protoTest() {

        LOGGER.info("Start test");
        CategoriesPage categoriesPage = new CategoriesPage(getContext());
        sleeping();

        LOGGER.info("Open 'Transport' category");
        CategoryPage transport = categoriesPage.openCategory("Transport")
                .andGetCategoryPage(getContext());
        sleeping();

        LOGGER.info("Open 'Cars' sub-category");
        CategoryPage cars = transport.openSubCategory("Cars")
                .andGetCategoryPage(getContext());
        sleeping();

        LOGGER.info("Open 'Volvo' sub-category");
        FilterPage volvoFilter = cars.openSubCategory("Volvo")
                .andGetFilterPage(getContext());
        sleeping();

        LOGGER.info("Open 'Volvo' sub-category");
        volvoFilter.selectAdvertisementByIndex(0);
        sleeping();
    }

    @Test
    public void protoTest2() {

        AdvertisementRow advertisement = new CategoriesPage(getContext())
                .openCategory("Transport")
                .andGetCategoryPage(getContext())
                .openSubCategory("Cars")
                .andGetCategoryPage(getContext())
                .openSubCategory("Volvo")
                .andGetFilterPage(getContext())
                .getAdvertisementByIndex(0);

        String wording = advertisement.getWording();

        advertisement.openAdvertisement()
                .clickAddToFavorites()
                .andGetAlertPopup(getContext())
                .clickOk()
                .andGetApplicationHeader(getContext())
                .openFavorites()
                .getAdvertisementGroupByCategory("Volvo")
                .verifyAdvertisementPresentByWording(wording);
    }

    private void sleeping() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
