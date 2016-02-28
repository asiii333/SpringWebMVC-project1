package com.bona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Asia on 2015-12-19.
 */
@Controller
@RequestMapping(value = "/")
public class HomeControler {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
