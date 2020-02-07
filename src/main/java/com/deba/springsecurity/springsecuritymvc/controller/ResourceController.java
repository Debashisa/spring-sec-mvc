package com.deba.springsecurity.springsecuritymvc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
public class ResourceController {

    @GetMapping(path = {"/"})
    public ModelAndView home(){
        System.out.println("Inside Home controller");
        ModelAndView login=new ModelAndView();
        login.setViewName("home");
        return login;

    }

    @GetMapping(path = {"/login"})
    public ModelAndView login(){
        System.out.println("Inside login controller");
        ModelAndView login=new ModelAndView();
        login.setViewName("login");
        return login;

    }

    @RequestMapping(value = "/userauth", method = RequestMethod.GET)
    public ModelAndView acceptLogin(){
       ModelAndView acceptViewModel=new ModelAndView();
       acceptViewModel.setViewName("storeresource");

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User is :: "+auth.getName());
        System.out.println("You are in userauth");
        acceptViewModel.addObject("userwelcome", "Welcome "+auth.getName());
        return acceptViewModel;
    }

    @RequestMapping(value = "/storeresource", method = RequestMethod.POST)
    public ModelAndView storeResource(){
        ModelAndView acceptViewModel=new ModelAndView();
        acceptViewModel.setViewName("enterresource");
        return acceptViewModel;
    }



}
