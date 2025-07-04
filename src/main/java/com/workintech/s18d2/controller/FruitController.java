package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private FruitService fruitService;

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping
    public List<Fruit> get(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive(message = "id 0dan küçük olamaz")@PathVariable("id") Long id){
        return new FruitResponse("get by id succeed", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@Size(min=2, max=45, message = "Name size must be between 2 to 45") @PathVariable("name") String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@NotNull @Positive @PathVariable Long id){
        return fruitService.delete(id);
    }
}
