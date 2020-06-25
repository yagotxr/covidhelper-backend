package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.User;

public interface UserService {

    User findUser(String userId);

    boolean existsById(String userId);
}
