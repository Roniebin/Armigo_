package org.example.virtualfittingshop.domain.image.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.example.virtualfittingshop.domain.image.service.FusingImageService;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final FusingImageService fusingImageService;

    @PostMapping("/fussing")
    @Operation(summary = "옷 합성", description = "일단 사용 금지")
    public String data(@ModelAttribute @RequestBody RequestFusingImage requestFusingImage) throws Exception {
        if(requestFusingImage.getImage1().isEmpty() || requestFusingImage.getImage2().isEmpty())
            return "이미지를 모두 입력하세요";
        return fusingImageService.callFusionApi(requestFusingImage);
    }

}

