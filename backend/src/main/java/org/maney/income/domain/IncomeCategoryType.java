package org.maney.income.domain;

public abstract class IncomeCategoryType {
    String name;
    String description;

    public IncomeCategoryType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
