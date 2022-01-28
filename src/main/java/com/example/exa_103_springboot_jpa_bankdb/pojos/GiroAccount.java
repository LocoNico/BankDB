package com.example.exa_103_springboot_jpa_bankdb.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("GIRO")
@AllArgsConstructor
public class GiroAccount extends Account{

    private Double overdraft;
    private Float debitInterest;
    private Float creditInterest;
}
