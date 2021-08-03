package com.afli.presentation.user.controller;

import com.afli.persistence.user.dao.AfliUserDao;
import com.afli.persistence.user.entity.AfliUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AfliUserController {

    private final AfliUserDao afliUserDao;

    @Autowired
    public AfliUserController(AfliUserDao afliUserDao) {
        this.afliUserDao = afliUserDao;
    }

    @GetMapping("/api/v1/users")
    public Map<String, List<AfliUser>> getAllUsers() {
        List<AfliUser> users = afliUserDao.findAllUsers();
        return Collections.singletonMap("users", users);
    }
}
