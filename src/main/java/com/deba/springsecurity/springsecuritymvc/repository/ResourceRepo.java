package com.deba.springsecurity.springsecuritymvc.repository;

import com.deba.springsecurity.springsecuritymvc.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepo extends JpaRepository<Resource,Integer> {

    Resource findResourceById(String id);
    Resource findByUsername(String resourceName);
}
