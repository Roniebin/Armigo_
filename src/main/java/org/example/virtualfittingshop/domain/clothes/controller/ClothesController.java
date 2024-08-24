package org.example.virtualfittingshop.domain.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.dto.ClothesDto;
import org.example.virtualfittingshop.domain.clothes.dto.ResponseGetClothes;
import org.example.virtualfittingshop.domain.clothes.service.ClothesService;
import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.example.virtualfittingshop.domain.image.service.FusingImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ClothesController {
    private final FusingImageService fusingImageService;
    private final ClothesService clothesService;

    @GetMapping("/go")
    public String go() {
        return "index";
    }

    @GetMapping("/getList")
    @ResponseBody
    public ResponseEntity<List<ResponseGetClothes>> getClothes() {
        //getClothesList
        return ResponseEntity.ok(Collections.singletonList(new ResponseGetClothes()));
    }

    @PostMapping("/fusing")
    @ResponseBody
    public ResponseEntity<String> diffUsingClothes(@ModelAttribute RequestFusingImage requestFusingImage) throws Exception {
        //send image data to model
        String tempReturnDAta = fusingImageService.callFusionApi(requestFusingImage);
        return ResponseEntity.ok(tempReturnDAta);
    }


    @GetMapping("")
    public String clothesList(Model model){
        List<Clothes> allClothes = clothesService.findAllClothes();
        model.addAttribute("items", allClothes);
        return "items/itemList";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("form", new ClothesDto());
        return "items/createItemForm";
    }

    @PostMapping("/new")
    public String createClothes(ClothesDto clothesDto){

        Clothes clothes = Clothes.builder()
                .name(clothesDto.getName())
                .description(clothesDto.getDescription())
                .price(clothesDto.getPrice())
                .quantity(clothesDto.getQuantity())
                .build();

        clothesService.save(clothes);
        return "redirect:/items";
    }

    @GetMapping("/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){

        Clothes clothes = clothesService.findClothesById(itemId);

        ClothesDto clothesDto = new ClothesDto();

        clothesDto.setId(itemId);
        clothesDto.setName(clothes.getName());
        clothesDto.setDescription(clothes.getDescription());
        clothesDto.setPrice(clothes.getPrice());
        clothesDto.setQuantity(clothes.getQuantity());
        model.addAttribute("form", clothesDto);

        return "items/updateItemForm";
    }

    @PostMapping("/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") ClothesDto clothesDto){

        Clothes clothes = Clothes.builder()
                .id(clothesDto.getId())
                .name(clothesDto.getName())
                .description(clothesDto.getDescription())
                .price(clothesDto.getPrice())
                .quantity(clothesDto.getQuantity())
                .build();

        clothesService.save(clothes);
        return "redirect:/items";
    }
}
