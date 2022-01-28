package com.example.exa_103_springboot_jpa_bankdb.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
public class Customer {

    @Id
    private Long customerId;
    @Column(length = 100)
    private String firstname;
    @Column(length = 100)
    private String lastname;
    private Long customerNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthdate;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts = new ArrayList<>();
}
