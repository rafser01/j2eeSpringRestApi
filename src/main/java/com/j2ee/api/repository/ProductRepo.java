/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2ee.api.repository;

import com.j2ee.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

//@Service
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
