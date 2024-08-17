package org.example.virtualfittingshop.domain.member.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class Address {
    private String city;
    private String Street;
    private String Zipcode;
}
