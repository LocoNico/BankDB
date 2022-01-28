package com.example.exa_103_springboot_jpa_bankdb.repos;

import com.example.exa_103_springboot_jpa_bankdb.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from customer c where c.lastname like %?1%")
    List<Customer> findCustomersByLastnameStartingWith(String lastname);
}