package com.afli.persistence.user.dao;

import com.afli.persistence.user.entity.AfliEmployee;

import java.util.List;

public interface AfliEmployeeDao {

    List<AfliEmployee> findAllEmployees();
}
