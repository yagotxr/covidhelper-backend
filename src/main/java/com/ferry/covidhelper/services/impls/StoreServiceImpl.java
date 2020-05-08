package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.exceptions.BadRequestException;
import com.ferry.covidhelper.exceptions.NotFoundException;
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
            throw new BadRequestException("Store is already registered.");
        }
        return storeRepository.insert(newStore);
    }

    @Override
    public void deleteStore(String storeId) {
        if(storeRepository.existsById(storeId)){
            storeRepository.deleteById(storeId);
        }
        throw new NotFoundException("Store doesn't exists.");
    }

    @Override
    public Store findStoreById(String storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new NotFoundException("Store not found."));
    }

    @Override
    public boolean existsById(String storeId) {
        return storeRepository.existsById(storeId);
    }

}
