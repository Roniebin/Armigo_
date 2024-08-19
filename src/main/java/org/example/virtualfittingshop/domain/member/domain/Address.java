package org.example.virtualfittingshop.domain.member.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;


@Getter
@Embeddable
public class Address {
    private String city;
    private String Street;
    private String Zipcode;
}
