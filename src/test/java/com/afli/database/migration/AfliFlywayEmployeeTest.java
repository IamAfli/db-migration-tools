package com.afli.database.migration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@DataJpaTest
public class AfliFlywayEmployeeTest {

    private static final String FIND_ALL_COMPANIES = "" +
            "SELECT name " +
            "FROM companies";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void companiesTableIsInitializedProperly() {
        // when
        List<String> companies =
                jdbcTemplate.query(FIND_ALL_COMPANIES, (rs, rowNum) -> rs.getString("name"));

        // then
        Assertions.assertThat(companies)
                .containsExactlyInAnyOrder(
                        "google",
                        "e-corp"
                );
    }
}
