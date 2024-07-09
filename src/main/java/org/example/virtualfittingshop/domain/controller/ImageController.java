package org.example.virtualfittingshop.domain.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.dto.RequestImageDto;
import org.example.virtualfittingshop.domain.service.ImageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/send/image")
    public String data(@ModelAttribute RequestImageDto tempDto) throws Exception {
        if(tempDto.getImage1().isEmpty() || tempDto.getImage2().isEmpty())
            return "이미지를 모두 입력하세요";

        return imageService.callDiffusionApi(tempDto);
    }
}

