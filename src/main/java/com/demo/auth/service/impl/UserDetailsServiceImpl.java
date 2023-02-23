package com.demo.auth.service.impl;

import com.demo.auth.entity.UserEntity;
import com.demo.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).authorities("USER").build();
        return userDetails;
    }
}