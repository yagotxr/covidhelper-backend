package com.ferry.covidhelper.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String stock;

}
