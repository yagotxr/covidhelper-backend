package com.ferry.covidhelper.payloads.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class ProductRegistrationRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("stock")
    private long stock;

}
