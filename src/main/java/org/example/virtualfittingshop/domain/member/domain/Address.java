package org.example.virtualfittingshop.domain.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Schema(description = "시")
    private String city;
    @Schema(description = "도로명")
    private String Street;
    @Schema(description = "우편번호")
    private String Zipcode;

}
