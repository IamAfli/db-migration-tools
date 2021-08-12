package com.afli.database.migration;

import com.afli.persistence.user.entity.AfliEmployee;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
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

    private static final String FIND_ALL_EMPLOYEES = "" +
            "SELECT u.id u_id, u.username u_username, u.first_name u_first_name, u.last_name u_last_name, e.title e_title, c.name c_name " +
            "FROM users u " +
            "JOIN employees e ON u.id = e.user_id " +
            "JOIN companies c ON c.id = e.company_id";

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

    @Test
    void employeesTableIsInitializedProperly() {
        // when
        List<AfliEmployee> employees =
                jdbcTemplate.query(FIND_ALL_EMPLOYEES, (rs, rowNum) ->
                        new AfliEmployee()
                                .setUsername(rs.getString("u_username"))
                                .setFirstName(rs.getString("u_first_name"))
                                .setLastName(rs.getString("u_last_name"))
                                .setTitle(rs.getString("e_title"))
                                .setCompany(rs.getString("c_name"))
                );

        // then
        Assertions.assertThat(employees)
                .extracting(
                        AfliEmployee::getUsername, AfliEmployee::getFirstName, AfliEmployee::getLastName,
                        AfliEmployee::getTitle, AfliEmployee::getCompany)
                .containsExactlyInAnyOrder(
                        Tuple.tuple("john.doe@gmail.com", "John", "Doe", "software engineer", "e-corp"),
                        Tuple.tuple("spider.man@gmail.com", "Peter", "Parker", "courier", "e-corp"),
                        Tuple.tuple("il.gusevskiy@gmail.com", "Afli", "Legend", "CEO", "e-corp"),
                        Tuple.tuple("bot_1@gmail.com", "Dummy_firstname", "Dummy_lastname", "junior software engineer", "google"),
                        Tuple.tuple("bot_2@gmail.com", "Dummier_firstname", "Dummier_lastname", "junior software engineer", "google")
                );
    }
}
