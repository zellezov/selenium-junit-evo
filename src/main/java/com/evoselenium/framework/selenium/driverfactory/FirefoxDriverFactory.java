package com.evoselenium.framework.selenium.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Properties;

public class FirefoxDriverFactory extends AbstractDriverFactory implements IDriverFactory {

    @Override
    public void init(Properties properties) {
        super.init(properties);
    }

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\java\\com\\evoselenium\\framework\\selenium\\driverfactory\\drivers\\geckodriver.exe"); //todo: set shorter path
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        FirefoxOptions options = new FirefoxOptions()
                .setAcceptInsecureCerts(true)
                .setLegacy(false);
        options.setCapability("specificationLevel", 1);

        return new FirefoxDriver(options);
    }
}
