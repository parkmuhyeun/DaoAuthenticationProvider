package com.muto.Standard.config.auth;

import com.muto.Standard.domain.User;
import com.muto.Standard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user =  userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        return new UserDetailsImpl(user);
    }
}