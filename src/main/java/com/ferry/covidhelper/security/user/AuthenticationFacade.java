package com.ferry.covidhelper.security.user;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
        Authentication getAuthentication();
}
