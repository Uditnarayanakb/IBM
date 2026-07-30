package org.bank.securitydemo;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        System.out.println("Loading user from UserDetailsService...");

        if("udit".equals(username)) {

            return User.withUsername("udit")
                    .password("{noop}1234")
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException(
                "User not found");
    }
}