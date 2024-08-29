package org.example.virtualfittingshop.domain.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestLogin {
    @Schema(description = "훠원이름")
    @NotEmpty
    private String name;

    @Schema(description = "비밀번호")
    @NotEmpty
    private String password;
}
