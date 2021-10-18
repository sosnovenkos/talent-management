package ru.iflexible.talent_management.common;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import javax.sql.DataSource;

@SpringJUnitConfig
@SpringBootTest(
        classes = {ru.iflexible.talent_management.application.TalentManagementApplication.class, IntegrationTestConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource("classpath:application.properties")
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTest {
    @Getter
    @Setter
    protected TestInfo testInfo;
    @Getter
    @Autowired
    protected TestSqlScriptPaths testSqlScriptPaths;
    @Getter
    @Autowired
    protected DataSource dataSource;
}
