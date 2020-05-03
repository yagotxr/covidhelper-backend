package com.ferry.covidhelper.domains.subDomains;

import com.ferry.covidhelper.payloads.requests.StoreRegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@AllArgsConstructor
public class Address {

    @Field("zipCode")
    private final String zipCode;

    @Field("street")
    private final String street;

    @Field("city")
    private final String city;

    @Field("state")
    private final String state;

    @Field("addOn")
    private final String addOn;

    @Field("addressNumber")
    private final String addressNumber;

    public static Address getAddressFromRequest(StoreRegisterRequest request){
        return new Address(
                request.getZipCode(),
                request.getStreet(),
                request.getCity(),
                request.getState(),
                request.getAddOn(),
                request.getAddressNumber());
    }
}
