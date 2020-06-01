package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.exceptions.NotFound;
import com.ferry.covidhelper.repositories.UserRepository;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

    @Override
    public User findUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFound("User not found with id [" + userId + "]"));
    }
}
