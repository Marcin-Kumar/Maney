package org.maney.income.domain;

public interface IncomeCategoryRepository {
    void create(IncomeCategoryModel incomeCategoryModel);

    IncomeCategoryModel findByName(String name);

    void deleteById(String id);
}
