package com.stooc.ecommerce.controller;

import com.stooc.ecommerce.productservice.ProductService;
import com.stooc.ecommerce.record.ProductPurchaseRequest;
import com.stooc.ecommerce.record.ProductPurchaseResponse;
import com.stooc.ecommerce.record.ProductRequest;
import com.stooc.ecommerce.record.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createproduct(@RequestBody @Valid ProductRequest request){
        Integer response =  productService.createProduct(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody List<ProductPurchaseRequest> productPurchaseRequests){
        List<ProductPurchaseResponse> response =  productService.purchaseProducts(productPurchaseRequests);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("productId") Integer productId){
        ProductResponse response = productService.findById(productId);
        return  ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> responses = productService.findAllProducts();
        return ResponseEntity.ok(responses);
    }
}
