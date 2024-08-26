package org.example.virtualfittingshop.domain.image.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestFusingImage {
    @Override
    public String toString() {
        return "TempDto{" +
                "image1=" + image1 +
                ", image2=" + image2 +
                '}';
    }
    @Schema(description = "사람 사진")
    @NotEmpty
    private MultipartFile image1;

    @Schema(description = "옷 사진")
    @NotEmpty
    private MultipartFile image2;
}
