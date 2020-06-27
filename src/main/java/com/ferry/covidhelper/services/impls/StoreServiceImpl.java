package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.exceptions.BadRequest;
import com.ferry.covidhelper.exceptions.Forbidden;
import com.ferry.covidhelper.exceptions.NotFound;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;
import com.ferry.covidhelper.repositories.StoreRepository;
import com.ferry.covidhelper.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store registerNewStore(StoreRegistrationRequest registrationRequest, User user) {
        Store newStore = Store.of(registrationRequest, user);
        if (storeRepository.existsByCnpj(newStore.getCnpj())) {
            throw new BadRequest("A store with this CNPJ has already been registered.");
        }
        return storeRepository.insert(newStore);
    }

    @Override
    public void deleteStore(Store store) {
        storeRepository.delete(store);
    }

    @Override
    public Store getUsersStore(String storeId, User user) {
        Store store = findStore(storeId);
        if (store.belongsTo(user)) {
            return store;
        }
        throw new Forbidden("This store is not connected to this account.");
    }

    private Store findStore(String storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFound("Store not found."));
    }

    @Override
    public boolean existsById(String storeId) {
        return storeRepository.existsById(storeId);
    }

    @Override
    public List<Store> findStoresByCity(String city) {
        return storeRepository.findAllByCity(city);
    }

    @Override
    public Store getStoreById(String storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFound("Store not found"));
    }
}
