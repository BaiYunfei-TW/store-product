package com.example.storeproduct.controller;

import com.example.storeproduct.service.ProductService;
import com.example.storeproduct.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> get(HttpServletRequest request, HttpServletResponse response) throws ServiceUnavailableException {
        return productService.getProducts();
    }

}
