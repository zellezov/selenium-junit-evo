package com.evoselenium.tests;

import com.evoselenium.framework.page.ui.ApplicationHeaderPage;
import com.evoselenium.framework.selenium.SeleniumTestFramework;
import org.junit.Test;

public class Prototype extends SeleniumTestFramework {

    @Test
    public void protoTest() {

        ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(getContext());
        sleeping();
        applicationHeaderPage.openSearch();
        sleeping();
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
