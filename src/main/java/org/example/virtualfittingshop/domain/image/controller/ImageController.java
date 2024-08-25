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
@RequestMapping("/image")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final FusingImageService fusingImageService;

    @PostMapping("/fussing")
    public String data(@ModelAttribute RequestFusingImage requestFusingImage) throws Exception {
        if(requestFusingImage.getImage1().isEmpty() || requestFusingImage.getImage2().isEmpty())
            return "이미지를 모두 입력하세요";
        return fusingImageService.callFusionApi(requestFusingImage);
    }

}

