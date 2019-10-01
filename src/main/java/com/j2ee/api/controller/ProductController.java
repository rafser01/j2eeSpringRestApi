/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2ee.api.controller;

import com.j2ee.api.model.Product;
import com.j2ee.api.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
public class ProductController {
    @Autowired
    ProductRepo pr;
    
    @GetMapping(value = "/test")
    public Double test(@RequestParam int id) {
        System.out.println("------------- id "+id);
        return pr.findById(5).get().getPrice();
    }
    @PostMapping(value = "/findId")
    public Integer findId() {
        return pr.findById(5).get().getId();
    }
}
