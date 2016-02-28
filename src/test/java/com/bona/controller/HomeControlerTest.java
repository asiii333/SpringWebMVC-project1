package com.bona.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Asia on 2015-12-20.
 */
public class HomeControlerTest {

    @Test
    public void testHome() throws Exception {
        HomeControler controller = new HomeControler();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}