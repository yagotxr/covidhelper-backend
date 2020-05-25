package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.payloads.requests.ProductRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static lombok.AccessLevel.PRIVATE;

@Document(collection = "products")
@AllArgsConstructor(access = PRIVATE)
public class Product {

    @Id
    @Field("productId")
    private String productId;

    @Indexed
    @Field("storeId")
    private String storeId;

    @Field("name")
    private String name;

    @Field("stock")
    @Setter
    private long stock;

    public static Product of(ProductRegistrationRequest request, Store store){
        return new Product(
                new ObjectId().toString(),
                store.getId(),
                request.getName(),
                request.getStock()
        );
    }
}
