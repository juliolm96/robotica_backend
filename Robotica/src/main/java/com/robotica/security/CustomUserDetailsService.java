package com.robotica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robotica.security.dao.JDBCUser;
import com.robotica.security.models.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    JDBCUser userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Let people login with either username or email
    	User user;
    	
    	try {
    		user = userRepository.findByUsernameOrEmail(usernameOrEmail);
    	} catch(Exception e) {
    		System.err.println(e);
    		throw e;
    	}

        return UserPrincipal.create(user);
    }

    // Método utilizado por JwtAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(int id) throws UsernameNotFoundException {
    	//User es un model
        User user;
        try {
        	user = userRepository.findById(id);
        } catch(Exception e) {
        	throw e;
        }

        return UserPrincipal.create(user);
    }

}
