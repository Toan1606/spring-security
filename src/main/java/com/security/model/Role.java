package com.security.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<Customer> customers;
}
