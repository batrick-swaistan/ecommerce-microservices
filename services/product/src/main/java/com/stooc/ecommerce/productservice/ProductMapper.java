package com.stooc.ecommerce.productservice;

import com.stooc.ecommerce.entity.Category;
import com.stooc.ecommerce.entity.Product;
import com.stooc.ecommerce.record.ProductPurchaseResponse;
import com.stooc.ecommerce.record.ProductRequest;
import com.stooc.ecommerce.record.ProductResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(@Valid ProductRequest request) {

        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, @NotNull(message = "Quantity is mandatory") double quantity) {
    }
}