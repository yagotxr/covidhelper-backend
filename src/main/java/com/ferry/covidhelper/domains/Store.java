package com.ferry.covidhelper.domains;

import com.ferry.covidhelper.domains.subDomains.Address;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.ferry.covidhelper.domains.subDomains.Address.getAddressFromRequest;
import static lombok.AccessLevel.PRIVATE;

@Document(collection = "stores")
@Getter
@AllArgsConstructor(access = PRIVATE)
public class Store {

    @Id
    @Field("storeId")
    private String id;

    @Indexed
    @Field("userId")
    private String userId;

    @Field("name")
    private String name;

    @Indexed
    @Field("cnpj")
    private String cnpj;

    @Field("address")
    private Address address;

    @Field("phoneNumbers")
    private String[] phoneNumbers;

    public static Store of(StoreRegistrationRequest request, User user){
        return new Store(
                new ObjectId().toString(),
                user.getId(),
                request.getName(),
                request.getCnpj(),
                getAddressFromRequest(request),
                request.getPhoneNumbers()
        );
    }

    public boolean belongsTo(User user) {
        return StringUtils.equals(this.userId, user.getId());
    }
}
