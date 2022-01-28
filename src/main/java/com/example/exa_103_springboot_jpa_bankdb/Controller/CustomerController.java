package com.example.exa_103_springboot_jpa_bankdb.Controller;

import com.example.exa_103_springboot_jpa_bankdb.pojos.Customer;
import com.example.exa_103_springboot_jpa_bankdb.repos.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private List<Customer> customers;

    @GetMapping
    public String showDesign(){
        return "customers";
    }

    @PostMapping
    public String showCustomers(Model model, @RequestParam("lastname") String lastname){
        customers = customerRepository.findCustomersByLastnameStartingWith(lastname);
        customers.sort(Comparator.comparing(Customer::getLastname).thenComparing(Customer::getFirstname));
        model.addAttribute("customers", customers);
        return "customers";
    }
}
