package com.deba.springsecurity.springsecuritymvc.service;

import com.deba.springsecurity.springsecuritymvc.entity.Resource;
import com.deba.springsecurity.springsecuritymvc.entity.Role;
import com.deba.springsecurity.springsecuritymvc.repository.ResourceRepo;
import com.deba.springsecurity.springsecuritymvc.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    ResourceRepo resourceRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Resource saveResource(Resource resource){

        Role roles=roleRepo.findByRole("USER");
        resource.setPassword(bCryptPasswordEncoder.encode(resource.getPassword()));
        resource.setState(true);

        resource.setRole(new HashSet<Role>(Arrays.asList(roles)));

        Resource res=resourceRepo.save(resource);

        return res;
    }

}
