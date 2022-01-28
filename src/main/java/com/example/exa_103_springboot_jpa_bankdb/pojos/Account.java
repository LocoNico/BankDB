package com.example.exa_103_springboot_jpa_bankdb.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @Id
    private Long accountId;
    private Long accountNumber;
    private Double balance;

    @ManyToMany
    @JoinTable(name = "customer_account",
        joinColumns = {@JoinColumn(name = "account_id")},
        inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
            customer.getAccounts().add(this);
        }
    }

}
