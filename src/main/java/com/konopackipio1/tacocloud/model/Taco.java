package com.konopackipio1.tacocloud.model;

import java.util.List;

import lombok.Data;

@Data
public class Taco {

    private String name;
    List<Ingredient> ingredients;
    
}
