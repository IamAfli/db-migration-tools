package com.afli.persistence.user.dao.impl;

import com.afli.persistence.user.dao.AfliUserDao;
import com.afli.persistence.user.entity.AfliUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("afliJdbcUserDao")
public class AfliJdbcUserDao implements AfliUserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AfliJdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AfliUser> findAllUsers() {
        return jdbcTemplate
                .query("SELECT id, username, first_name, last_name FROM users", (rs, rowNum) -> new AfliUser()
                        .setId(rs.getLong("id"))
                        .setUsername(rs.getString("username"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                );
    }
}
