package ru.iflexible.talent_management.common;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


@TestConfiguration
@RequiredArgsConstructor
public class IntegrationTestConfiguration {

//    @Bean
//    public DatabaseAssert databaseAssert(DatabaseClient databaseClient) {
//        return new DatabaseAssert(databaseClient);
//    }

    @Bean
    public TestSqlScriptPaths testSqlScriptPaths() {
        return TestSqlScriptPaths.builder()
                .emptyTablesScriptPath("ru/iflexible/talent_management/application/db_script/empty_tables.sql")
//                .dropNotNullScriptPath("ru/iflexible/db_script/drop_not_null.sql")
//                .setNotNullScriptPath("ru/iflexible/db_script/set_not_null.sql")
                .build();
    }

}