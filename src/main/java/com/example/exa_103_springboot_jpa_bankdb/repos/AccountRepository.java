package com.example.exa_103_springboot_jpa_bankdb.repos;

import com.example.exa_103_springboot_jpa_bankdb.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}