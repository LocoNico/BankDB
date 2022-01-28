package com.example.exa_103_springboot_jpa_bankdb.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("SPAR")
public class SavingsAccount extends Account{

    private Double interest;
}
