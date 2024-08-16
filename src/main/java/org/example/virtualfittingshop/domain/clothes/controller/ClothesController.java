package org.example.virtualfittingshop.domain.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.dto.ResponseGetClothes;
import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.example.virtualfittingshop.domain.image.service.FusingImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clothes")
@RequiredArgsConstructor
public class ClothesController {
    private final FusingImageService fusingImageService;

    @GetMapping("/getList")
    public ResponseEntity<List<ResponseGetClothes>> getClothes() {
        //getClothesList
        return ResponseEntity.ok(Collections.singletonList(new ResponseGetClothes()));
    }

    @PostMapping("/fusing")
    public ResponseEntity<String> diffUsingClothes(@ModelAttribute RequestFusingImage requestFusingImage) throws Exception {
        //send image data to model
        String tempReturnDAta = fusingImageService.callFusionApi(requestFusingImage);
        return ResponseEntity.ok(tempReturnDAta);
    }
}
