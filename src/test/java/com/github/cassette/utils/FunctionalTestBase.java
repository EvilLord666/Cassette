package com.github.cassette.utils;

import java.io.FileNotFoundException;
import java.sql.*;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("functests")
public class FunctionalTestBase extends DatabaseRelatedTestBase {

    /*@BeforeEach
    public void setUp() throws DatabaseException, LiquibaseException, SQLException, FileNotFoundException{
        setUp("jdbc:mysql://localhost:3306/${spring.datasource.database-name}", "root", "1234",
            "src/main/resources/db/changelog/changelog-master.yml", "src/main/resources/data/db_test_data.sql");
    }*/
    @BeforeEach
    public void setUp() throws DatabaseException, LiquibaseException, SQLException, FileNotFoundException{
        setUp("jdbc:mysql://localhost:3306/${spring.datasource.database-name}", "root", "1234",
            "src/main/resources/db/changelog/changelog-master.yml", "docs/dbSchema/dbSchema.sql");
    }

    @AfterEach
    @Override
    public void tearDown() throws SQLException {
        super.tearDown();
    }

}
