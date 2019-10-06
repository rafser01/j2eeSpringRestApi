/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2ee.api.controller;

import com.j2ee.api.model.Product;
import com.j2ee.api.model.User;
import com.j2ee.api.repository.ProductRepo;
import com.j2ee.api.repository.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
    @Autowired
    ProductRepo pr;
    
    @Autowired
    UserRepo ur;
    
    @GetMapping(value = "/test")
    public Double test(@RequestParam int id) {
        System.out.println("------------- id "+id);
        return pr.findById(id).get().getPrice();
    }
    @PostMapping(value = "/findId")
    public Integer findId() {
        return pr.findById(5).get().getId();
    }
    
    @GetMapping(value = "/signin")
    public boolean signin(@RequestParam String userId, String password){
        try {
            System.out.println("---------- "+userId+password);
            User u = ur.findByName(userId);
            if(u.getPassword().equals(password)){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    @PostMapping (value = "/addProduct")
    public List<Product> addProducts(@RequestParam String name, double price, int qty){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setQty(qty);
        pr.save(p);
        return pr.findAll();
    }
}
