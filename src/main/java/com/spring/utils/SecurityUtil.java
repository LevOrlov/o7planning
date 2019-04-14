package com.spring.utils;

import java.util.List;


import com.spring.entity.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUserDetails;
import com.spring.social.SocialUserDetailsImpl;

public class SecurityUtil {

    // Auto Login.
    public static void logInUser(AppUser user, List<String> roleNames) {

        SocialUserDetails userDetails = new SocialUserDetailsImpl(user, roleNames);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}