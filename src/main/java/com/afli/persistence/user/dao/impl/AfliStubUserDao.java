package com.afli.persistence.user.dao.impl;

import com.afli.persistence.user.dao.AfliUserDao;
import com.afli.persistence.user.entity.AfliUser;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AfliStubUserDao implements AfliUserDao {

    @Override
    public List<AfliUser> findAllUsers() {
        AfliUser user1 = new AfliUser()
                .setId(1L)
                .setUsername("john.doe@gmail.com")
                .setFirstName("John")
                .setLastName("Doe");
        AfliUser user2 = new AfliUser()
                .setId(2L)
                .setUsername("spider.man@gmail.com")
                .setFirstName("Peter")
                .setLastName("Parker");
        AfliUser user3 = new AfliUser()
                .setId(3L)
                .setUsername("il.gusevskiy@gmail.com")
                .setFirstName("Afli")
                .setLastName("legend");
        return Arrays.asList(user1, user2, user3);
    }
}
