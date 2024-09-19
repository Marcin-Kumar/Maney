package org.maney.income.domain;

public class IncomeCategoryModel extends IncomeCategoryType {
    public IncomeCategoryModel(String name, String description) {
        super(name, description);
    }

    public IncomeCategoryModel(String name) {
        super(name, "");
    }
}
