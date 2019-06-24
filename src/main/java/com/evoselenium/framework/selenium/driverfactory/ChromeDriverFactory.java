package com.evoselenium.framework.selenium.driverfactory;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Properties;

public class ChromeDriverFactory extends AbstractDriverFactory implements IDriverFactory {

    @Override
    public void init(Properties properties) {
        super.init(properties);
    }

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\evoselenium\\framework\\selenium\\driverfactory\\drivers\\chromedriver.exe"); //todo: set shorter path
        return new ChromeDriver();
    }
}
