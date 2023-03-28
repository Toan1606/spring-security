package com.security.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "company", length = 50)
    private java.lang.String company;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private java.lang.String lastName;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private java.lang.String firstName;

    @Size(max = 50)
    @Column(name = "email_address", length = 50)
    private java.lang.String emailAddress;

    @Size(max = 50)
    @Column(name = "job_title", length = 50)
    private java.lang.String jobTitle;

    @Size(max = 25)
    @Column(name = "business_phone", length = 25)
    private java.lang.String businessPhone;

    @Size(max = 25)
    @Column(name = "home_phone", length = 25)
    private java.lang.String homePhone;

    @Size(max = 25)
    @Column(name = "mobile_phone", length = 25)
    private java.lang.String mobilePhone;

    @Size(max = 25)
    @Column(name = "fax_number", length = 25)
    private java.lang.String faxNumber;

    @Lob
    @Column(name = "address")
    private java.lang.String address;

    @Size(max = 50)
    @Column(name = "city", length = 50)
    private java.lang.String city;

    @Size(max = 50)
    @Column(name = "state_province", length = 50)
    private java.lang.String stateProvince;

    @Size(max = 15)
    @Column(name = "zip_postal_code", length = 15)
    private java.lang.String zipPostalCode;

    @Size(max = 50)
    @Column(name = "country_region", length = 50)
    private java.lang.String countryRegion;

    @Lob
    @Column(name = "web_page")
    private java.lang.String webPage;

    @Lob
    @Column(name = "notes")
    private java.lang.String notes;

    @Column(name = "attachments")
    private byte[] attachments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
