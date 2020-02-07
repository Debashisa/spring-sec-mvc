package com.deba.springsecurity.springsecuritymvc.service;

import com.deba.springsecurity.springsecuritymvc.entity.Resource;
import com.deba.springsecurity.springsecuritymvc.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    ResourceRepo resourceRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("incoming username is "+username);
        Resource user=resourceRepo.findByUsername(username);
        System.out.println("roles being added is ::"+ user.getRole());
        List<GrantedAuthority> listAUth=new ArrayList<>();
        user.getRole().forEach(role ->  {
            listAUth.add(new SimpleGrantedAuthority(role.getRole()));
        });

        return new User(user.getUsername(), user.getPassword(),true,true,true,true,listAUth);
    }
}
