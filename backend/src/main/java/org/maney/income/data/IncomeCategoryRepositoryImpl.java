package org.maney.income.data;

import org.maney.data.SqlDataSource;
import org.maney.income.domain.IncomeCategoryModel;
import org.maney.income.domain.IncomeCategoryRepository;
import java.util.UUID;

public class IncomeCategoryRepositoryImpl implements IncomeCategoryRepository {
    private final SqlDataSource dataSource;

    IncomeCategoryRepositoryImpl(SqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(IncomeCategoryModel incomeCategoryModel) {
        try {
            String insertCategorySqlString = "INSERT INTO income_categories (\n" +
                    "    income_category_id,\n" +
                    "    name\n" +
                    "    description\n" +
                    ") VALUES( " +
                    UUID.randomUUID() +"," +
                    incomeCategoryModel.getName() + "," +
                    incomeCategoryModel.getDescription() +
                    ")";

            dataSource.executeStatement(insertCategorySqlString);
        } catch (Exception e) {
            System.err.println(incomeCategoryModel + "could not be created");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public IncomeCategoryModel findByName(String name) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
