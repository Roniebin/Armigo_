package org.example.virtualfittingshop.domain.clothes.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.service.ClothesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clothes")
@RequiredArgsConstructor
public class ClothesController {
    private final ClothesService clothesService;

    @GetMapping("/getAll")
    @Operation(summary = "모든 옷 가져오기")
    public ResponseEntity<List<Clothes>> getAllClothes() {
        //getClothesList
        List<Clothes> allClothes = clothesService.findAllClothes();
        return ResponseEntity.ok(allClothes);
    }

    @GetMapping("/get")
    @Operation(summary = "옷 한 벌 가져오가", description = "원하는 제품이 아이디 값 전달")
    public ResponseEntity<Clothes> getClotheById(@RequestParam("clothes_id") Long id) {

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
