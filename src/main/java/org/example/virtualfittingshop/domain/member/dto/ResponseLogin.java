package org.example.virtualfittingshop.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.virtualfittingshop.domain.member.domain.Address;
import org.example.virtualfittingshop.global.norm.MemberType;

@Data
@AllArgsConstructor
public class ResponseLogin {
    @Schema(description = "key")
    private Long id;

    @Schema(description = "회원명")
    private String name;

    @Schema(description = "MemberType으로 BUYER와 SELLER로 정의")
    private MemberType type;

    @Schema(description = "주소")
    private Address address;
}
