package org.example.virtualfittingshop.domain.image.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.example.virtualfittingshop.domain.image.service.FusingImageService;
import org.example.virtualfittingshop.domain.image.service.ImageTestService;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final FusingImageService fusingImageService;
    private final ImageTestService imageTestService;
    @PostMapping("/send/image")
    public String data(@ModelAttribute RequestFusingImage tempDto) throws Exception {
        if(tempDto.getImage1().isEmpty() || tempDto.getImage2().isEmpty())
            return "이미지를 모두 입력하세요";
        return fusingImageService.callFusionApi(tempDto);
    }

}

