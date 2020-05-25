package com.ferry.covidhelper.security.user;

import com.ferry.covidhelper.exceptions.OAuth2AuthenticationProcessingException;

import java.util.Map;

import static com.ferry.covidhelper.security.user.AuthProviders.FACEBOOK;
import static com.ferry.covidhelper.security.user.AuthProviders.GOOGLE;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(GOOGLE)) {
            return new GoogleUserInfo(attributes);
        }
        else if (registrationId.equalsIgnoreCase(FACEBOOK)) {
            return new FacebookUserInfo(attributes);
        }
        else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
