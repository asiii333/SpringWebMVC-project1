package com.bona.controller;

import com.bona.data.Spitter;
import com.bona.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Asia on 2015-12-30.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository repository;

    @Autowired
    public SpitterController(SpitterRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistartion(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        repository.save(spitter);
        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showNewProfile(@PathVariable String username, Model model ){
        Spitter spitter = repository.findByUser(username);
        model.addAttribute(spitter);
        return "newProfile";

    }
}
