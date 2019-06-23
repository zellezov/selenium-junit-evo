package com.evoselenium.framework.selenium.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class ChromeDriverFactory extends AbstractDriverFactory implements IDriverFactory {

    @Override
    public void init(Properties properties) {
        super.init(properties);
    }

    @Override
    public WebDriver getWebDriver() {
        return new ChromeDriver();
    }
}
