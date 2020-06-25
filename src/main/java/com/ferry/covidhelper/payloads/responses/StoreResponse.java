package com.ferry.covidhelper.payloads.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.subDomains.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(onConstructor_ = @JsonCreator, access = PRIVATE)
public class StoreResponse {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("cnpj")
    private final String cnpj;

    @JsonProperty("address")
    private final Address address;

    @JsonProperty("phoneNumbers")
    private final String[] phoneNumbers;

    public static StoreResponse of(Store store){
        return new StoreResponse(
                store.getId(),
                store.getName(),
                store.getCnpj(),
                store.getAddress(),
                store.getPhoneNumbers()
        );
    }
}
