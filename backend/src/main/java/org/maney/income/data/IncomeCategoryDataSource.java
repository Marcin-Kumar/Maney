package org.maney.income.data;

import org.maney.data.SqlDataSource;

import java.util.Properties;

public class IncomeCategoryDataSource extends SqlDataSource {

    public IncomeCategoryDataSource(
            String dataSourceUrl,
            Properties dataSourceProperties
    ) {
        super(dataSourceUrl, dataSourceProperties);
    }
}
