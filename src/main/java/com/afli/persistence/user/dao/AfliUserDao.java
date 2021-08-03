package com.afli.persistence.user.dao;

import com.afli.persistence.user.entity.AfliUser;

import java.util.List;

public interface AfliUserDao {

    List<AfliUser> findAllUsers();
}
