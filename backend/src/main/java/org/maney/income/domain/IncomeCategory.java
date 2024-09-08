package org.maney.income.domain;

public class IncomeCategory {
    public String get_name() {
        return _name;
    }

    public String get_description() {
        return _description;
    }

    final private String  _name;
    final private String  _description;

    public IncomeCategory(String name, String description) {
        _name = name;
        _description = description;
    }

    public IncomeCategory(String name) {
        _name = name;
        _description = "";
    }
}
