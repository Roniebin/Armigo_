package org.example.virtualfittingshop.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.example.virtualfittingshop.global.norm.MemberType;


@Data
public class MemberForm {

    @Schema(description = "이름")
    @NotEmpty
    private String name;

    @Schema(description = "비밀번호")
    @NotEmpty
    private String password;

    @Schema(description = "회원 타입")
    @NotEmpty
    private MemberType type;
    @Schema(description = "시")
    @NotEmpty
    private String city;
    @Schema(description = "도로명")
    @NotEmpty
    private String street;
    @Schema(description = "우편번호")
    @NotEmpty
    private String zipcode;
}
