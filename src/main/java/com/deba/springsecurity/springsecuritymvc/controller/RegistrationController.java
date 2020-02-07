package com.deba.springsecurity.springsecuritymvc.controller;

import com.deba.springsecurity.springsecuritymvc.entity.Resource;
import com.deba.springsecurity.springsecuritymvc.repository.ResourceRepo;
import com.deba.springsecurity.springsecuritymvc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping(path = "/registration" , method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView registration=new ModelAndView();
        Resource resource=new Resource();
        registration.setViewName("registration");
        registration.addObject(resource);
        return registration;
    }

    @PostMapping(path = "/registration")
    public ModelAndView createUser(@ModelAttribute("resource") Resource resource){

        Optional optional=Optional.of(resourceService.saveResource(resource));

        if(optional.isPresent())
        {
            System.out.println("User creation successful !!!");
        }
        else{
            System.out.println("Try Again !!!");
        }

        ModelAndView registration =new ModelAndView();
//        Resource resourceNew=new Resource();
//        registration.addObject(resourceNew);
        registration.setViewName("login");

        return registration;
    }
}
