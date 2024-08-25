package org.example.virtualfittingshop.domain.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.service.ClothesService;
import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.example.virtualfittingshop.domain.image.service.FusingImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clothes")
@RequiredArgsConstructor
public class ClothesController {
    private final FusingImageService fusingImageService;
    private final ClothesService clothesService;

    @GetMapping("/getList")
    public ResponseEntity<List<Clothes>> getAllClothes() {
        //getClothesList
        List<Clothes> allClothes = clothesService.findAllClothes();
        return ResponseEntity.ok(allClothes);
    }

    @GetMapping("/get")
    public ResponseEntity<Clothes> getClotheById(@RequestParam Long id) {

        Clothes clothes = clothesService.findClothesById(id);
        return ResponseEntity.ok(clothes);
    }

//    @PutMapping("/update")
//    public Res

//    @PostMapping("/fusing")
//    public ResponseEntity<String> diffusingClothes(@ModelAttribute RequestFusingImage requestFusingImage) throws Exception {
//        //send image data to model
//        String tempReturnDAta = fusingImageService.callFusionApi(requestFusingImage);
//        return ResponseEntity.ok(tempReturnDAta);
//    }
}
