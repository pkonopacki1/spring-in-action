package com.konopackipio1.tacocloud;

import java.util.List;

import lombok.Data;

@Data
public class Taco {

    private String name;
    List<Ingredient> ingredients;
    
}
