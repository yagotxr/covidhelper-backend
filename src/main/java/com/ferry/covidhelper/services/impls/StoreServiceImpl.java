package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.exceptions.BadRequest;
import com.ferry.covidhelper.repositories.StoreRepository;
import com.ferry.covidhelper.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store registerNewStore(Store newStore) {
        if(storeRepository.exists(Example.of(newStore))){
            throw new BadRequest("Store is already registered.");
        }
        return storeRepository.insert(newStore);
    }

}