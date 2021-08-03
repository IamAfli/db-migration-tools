package com.afli.persistence.user.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AfliUser {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
