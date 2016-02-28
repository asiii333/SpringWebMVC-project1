package com.bona.controller;

import com.bona.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Asia on 2015-12-20.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private final SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId")long spittleId, Model model){
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }
}
