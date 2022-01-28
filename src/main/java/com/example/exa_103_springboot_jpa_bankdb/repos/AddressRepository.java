package com.example.exa_103_springboot_jpa_bankdb.repos;

import com.example.exa_103_springboot_jpa_bankdb.pojos.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}