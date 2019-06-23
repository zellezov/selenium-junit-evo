package com.evoselenium.tests;

import com.evoselenium.framework.page.ui.ApplicationHeaderPage;
import com.evoselenium.framework.selenium.SeleniumTestFramework;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prototype extends SeleniumTestFramework {

    private static final Logger LOGGER = LoggerFactory.getLogger(Prototype.class.getName());

    @Test
    public void protoTest() {

        LOGGER.info("Start test");
        ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(getContext());
        sleeping();

        LOGGER.info("Go to 'Search' page");
        applicationHeaderPage.openSearch();
        sleeping();

        LOGGER.info("Go to 'Favorites' page");
        applicationHeaderPage.openFavorites();
        sleeping();
    }

    private void sleeping() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
