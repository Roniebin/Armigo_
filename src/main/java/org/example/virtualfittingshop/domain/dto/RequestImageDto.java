package org.example.virtualfittingshop.domain.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestImageDto {
    @Override
    public String toString() {
        return "TempDto{" +
                "image1=" + image1 +
                ", image2=" + image2 +
                '}';
    }

    private MultipartFile image1;
    private MultipartFile image2;

}
