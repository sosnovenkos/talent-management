package ru.iflexible.talent_management.common;

import lombok.SneakyThrows;
import lombok.var;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import javax.sql.DataSource;

public interface DatabaseTest {
    DataSource getDataSource();

    TestSqlScriptPaths getTestSqlScriptPaths();

    @BeforeAll
    default void beforeAllDropNotNullAndEmptyTables() {
//        executeSqlScript(getTestSqlScriptPaths().getEmptyTablesScriptPath());
    }

    @AfterEach
    default void afterEachEmptyTables() {
        executeSqlScript(getTestSqlScriptPaths().getEmptyTablesScriptPath());
    }

    @AfterAll
    default void afterAllEmptyTablesAndSetNotNull() {
//        executeSqlScript(getTestSqlScriptPaths().getEmptyTablesScriptPath());
    }

    @SneakyThrows
    default void executeSqlScript(String classPath) {
        String script = FileCopyUtils.copyToString(
                new EncodedResource(new ClassPathResource(classPath)).getReader());
        var subScripts = script.split(";");
        for (var subScript : subScripts) {
            getDataSource().getConnection().createStatement().execute(subScript.replace(";", ""));
        }
    }
}