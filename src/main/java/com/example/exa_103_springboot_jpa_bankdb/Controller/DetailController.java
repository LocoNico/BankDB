package com.example.exa_103_springboot_jpa_bankdb.Controller;

import com.example.exa_103_springboot_jpa_bankdb.pojos.Account;
import com.example.exa_103_springboot_jpa_bankdb.pojos.Customer;
import com.example.exa_103_springboot_jpa_bankdb.pojos.GiroAccount;
import com.example.exa_103_springboot_jpa_bankdb.repos.AccountRepository;
import com.example.exa_103_springboot_jpa_bankdb.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/details")
public class DetailController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    Customer customer;

    @PostMapping
    public String showCustomerDetails(@RequestParam("customer") Long customerId, Model model){
        customer = customerRepository.findById(customerId).get();
        model.addAttribute("customer", customer);
        return "customerDetails";
    }

    @PostMapping("/update")
    public String updateAccount(Model model, @RequestParam("accountId") Long accountId,
                                @RequestParam("amount") double amount,
                                @RequestParam("action") int action){
        Account account = accountRepository.findById(accountId).get();
        amount *= action;
        if(account instanceof GiroAccount){
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        }
        else{
            double newBalance = account.getBalance() + amount;
            if (!(newBalance < 0)){
                account.setBalance(newBalance);
                accountRepository.save(account);
            }
        }
        customer = customerRepository.findById(customer.getCustomerId()).get();
        model.addAttribute("customer", customer);
        return "customerDetails";
    }
}
