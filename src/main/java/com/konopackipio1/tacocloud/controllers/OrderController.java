package com.konopackipio1.tacocloud.controllers;

import com.konopackipio1.tacocloud.model.Order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String showOrderForm(Model model) {
        model.addAttribute(new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(Order order) {
        log.info("Order submitted: " + order);
        return "redirect:/";
    }

}
