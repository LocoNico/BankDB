package com.example.exa_103_springboot_jpa_bankdb.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "address")
public class Address {

    @Id
    private Long addressId;
    @Column(length = 100)
    private String streetname;
    @Column(length = 10)
    private String streetNumber;
    @Column(length = 10)
    private String zipCode;
    @Column(length = 100)
    private String city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
            customer.setAddress(this);
        }
    }
}
