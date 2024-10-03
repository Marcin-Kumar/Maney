package org.maney.income.domain;

public class IncomeCategoryEntity extends IncomeCategoryType {
    public IncomeCategoryEntity(String name, String description) {
        super(name, description);
    }

    public IncomeCategoryEntity(String name) {
        super(name, "");
    }
}
