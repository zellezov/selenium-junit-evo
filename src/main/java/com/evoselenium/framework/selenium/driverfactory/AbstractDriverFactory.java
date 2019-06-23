package com.evoselenium.framework.selenium.driverfactory;

import java.util.Properties;

public abstract class AbstractDriverFactory implements IDriverFactory {

    @Override
    public void init(Properties properties) {
        System.out.println(getClass().getSimpleName() + " initialized"); //todo change to normal logging
    }
}
