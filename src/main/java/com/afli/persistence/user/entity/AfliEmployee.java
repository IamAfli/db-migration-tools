package com.afli.persistence.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AfliEmployee extends AfliUser {

    private String title;
    private String company;

    @Override
    public AfliEmployee setId(Long id) {
        super.setId(id);
        return this;
    }

    @Override
    public AfliEmployee setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public AfliEmployee setFirstName(String firstName) {
        super.setFirstName(firstName);
        return this;
    }

    @Override
    public AfliEmployee setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }
}
