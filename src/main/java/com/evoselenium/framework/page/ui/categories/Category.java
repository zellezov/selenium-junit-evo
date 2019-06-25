package com.evoselenium.framework.page.ui.categories;

public enum Category {

    JOB_AND_BUSINESS("Job and business"),
    TRANSPORT("Transport"),
    REAL_ESTATE("Real estate"),
    CONSTRUCTION("Construction"),
    ELECTRONICS("Electronics"),
    CLOTHES_FOOTWEAR("Clothes, footwear"),
    HOME_STUFF("Home stuff"),
    PRODUCTION_WORK("Production, work"),
    FOR_CHILDREN("For children"),
    ANIMALS("Animals"),
    AGRICULTURE("Agriculture"),
    ENTERTAINMENT("Entertainment");

    private String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
