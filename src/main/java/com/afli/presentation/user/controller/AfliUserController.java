package com.afli.presentation.user.controller;

import com.afli.persistence.user.dao.AfliEmployeeDao;
import com.afli.persistence.user.dao.AfliUserDao;
import com.afli.persistence.user.entity.AfliEmployee;
import com.afli.persistence.user.entity.AfliUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AfliUserController {

    private final AfliUserDao afliUserDao;
    private final AfliEmployeeDao afliEmployeeDao;

    @Autowired
    public AfliUserController(@Qualifier("afliJdbcUserDao") AfliUserDao afliUserDao,
                              AfliEmployeeDao afliEmployeeDao) {
        this.afliUserDao = afliUserDao;
        this.afliEmployeeDao = afliEmployeeDao;
    }

    @GetMapping("/api/v1/users")
    public Map<String, List<AfliUser>> getAllUsers() {
        List<AfliUser> users = afliUserDao.findAllUsers();
        return Collections.singletonMap("users", users);
    }

    @GetMapping("/api/v1/employees")
    public Map<String, List<AfliEmployee>> getAllEmployees() {
        List<AfliEmployee> employees = afliEmployeeDao.findAllEmployees();
        return Collections.singletonMap("employees", employees);
    }
}
