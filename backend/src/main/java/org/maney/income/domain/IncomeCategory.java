package org.maney.income.domain;

public class IncomeCategory {
    String name;
    String description;

    public IncomeCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public IncomeCategory(String name) {
        this.name = name;
        description = "";
    }
}
