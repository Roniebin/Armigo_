package org.example.virtualfittingshop.domain.member.dto;

import lombok.Data;


@Data
public class MemberForm {
    private String name;
//    private MemberType type;
    private String city;
    private String street;
    private String zipcode;
}
