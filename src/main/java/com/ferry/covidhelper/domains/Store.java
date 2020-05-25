package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.domains.subDomains.Address;
import com.ferry.covidhelper.payloads.requests.StoreRegisterRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.ferry.covidhelper.domains.subDomains.Address.getAddressFromRequest;
import static lombok.AccessLevel.PRIVATE;

@Document(collection = "stores")
@AllArgsConstructor(access = PRIVATE)
public class Store {

    @Id
    private String storeId;

    @Indexed
    private String user;

    @Field("name")
    private String name;

    @Field("cnpj")
    private String cnpj;

    @Field("address")
    private Address address;

    @Field("phone")
    private String phone;

    public static Store of(User user, StoreRegisterRequest request){
        return new Store(
                new ObjectId().toString(),
                user.getId(),
                request.getName(),
                request.getCnpj(),
                getAddressFromRequest(request),
                request.getPhone()
        );
    }
}
