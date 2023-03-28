package com.security.utils;

import com.security.model.Customer;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private final Customer customer;

    public CustomGrantedAuthority(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getAuthority() {

        return null;
    }
}
