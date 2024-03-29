package org.api.enums;

public enum LogEnum {

    BUSSINESS("business"), PLATFORM("platform"),
    DB("db"), EXCEPTION("exception");

    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}