package com.konopackipio1.tacocloud.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.konopackipio1.tacocloud.model.Ingredient;
import com.konopackipio1.tacocloud.model.Taco;
import com.konopackipio1.tacocloud.model.TacoOrder;
import com.konopackipio1.tacocloud.model.Ingredient.Type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

// Lombok logger annotation
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignController {

    @GetMapping
    public String showDesignForm() { 
        return "design";
    }

    @PostMapping
    // @ModerAttribute before TacoOrder will retrieve it from model
    public String processDesignForm(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}" + taco);
        return "redirect:/orders/current";
    }    

    @ModelAttribute
    public void addIngredients(Model model) {
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
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));        
        }
    }

    private  List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
        .filter(i -> i.getType().equals(type))
        .collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

}
