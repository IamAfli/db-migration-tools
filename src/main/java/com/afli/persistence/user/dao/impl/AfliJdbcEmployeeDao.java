package com.afli.persistence.user.dao.impl;

import com.afli.persistence.user.dao.AfliEmployeeDao;
import com.afli.persistence.user.entity.AfliEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AfliJdbcEmployeeDao implements AfliEmployeeDao {

    private static final String FIND_ALL_EMPLOYEES = "" +
            "SELECT u.id u_id, u.username u_username, u.first_name u_first_name, u.last_name u_last_name, e.title e_title, c.name c_name " +
            "FROM users u " +
            "JOIN employees e ON u.id = e.user_id " +
            "JOIN companies c ON c.id = e.company_id";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AfliJdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AfliEmployee> findAllEmployees() {
        return jdbcTemplate
                .query(FIND_ALL_EMPLOYEES, (rs, rowNum) -> new AfliEmployee()
                        .setId(rs.getLong("u_id"))
                        .setUsername(rs.getString("u_username"))
                        .setFirstName(rs.getString("u_first_name"))
                        .setLastName(rs.getString("u_last_name"))
                        .setTitle(rs.getString("e_title"))
                        .setCompany(rs.getString("c_name"))
                );
    }
}
