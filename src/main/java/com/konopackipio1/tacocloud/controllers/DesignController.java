package com.konopackipio1.tacocloud.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.konopackipio1.tacocloud.model.Ingredient;
import com.konopackipio1.tacocloud.model.Taco;
import com.konopackipio1.tacocloud.model.Ingredient.Type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// Lombok logger annotation
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @GetMapping
    public String showDesignForm(Model model) {
        //todo: replace hardocred list with DB
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredient.Type.values();

        // Here we add object to model, which we than can use in the template
        for (Type type : types) {
            model.addAttribute(type.name().toLowerCase(), filterByType(ingredients, type));        
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private  List<Ingredient> filterByType(List<Ingredient> list, Type type) {
        return list.stream()
        .filter(i -> i.getType().equals(type))
        .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesignForm(Taco taco) {
        log.info("Processing taco: " + taco.getName());
        return "redirect:/orders/current";
    }

}
