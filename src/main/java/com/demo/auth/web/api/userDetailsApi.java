package com.demo.auth.web.api;

import com.demo.auth.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userDetails")
public class userDetailsApi {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @RequestMapping("getByEmail/{email}")
    public UserDetails getUserDetailsByEmail(@PathVariable String email) {
        return userDetailsServiceImpl.loadUserByUsername(email);
    }
}
