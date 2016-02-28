package com.bona.controller;

import com.bona.data.Spitter;
import com.bona.repository.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

/**
 * Created by Asia on 2015-12-30.
 */
public class SpitterControllerTest {

    SpitterRepository mockRepo = mock(SpitterRepository.class);
    private SpitterController controller = new SpitterController(mockRepo);
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    @Test
    public void testProcessingForm() throws Exception {
        Spitter unsaved = new Spitter("Jan","Bulbanski","bulba","adminadmin");
        Spitter saved = new Spitter(123l,"Jan","Bulbanski","bulba","adminadmin");
        when(mockRepo.save(unsaved)).thenReturn(saved);

        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName","Jan")
                .param("lastName", "Bulbanski")
                .param("userName","bulba")
                .param("password", "adminadmin"))
                .andExpect(redirectedUrl("/spitter/bulba"));
        verify(mockRepo,atLeastOnce()).save(unsaved);
    }

    @Test
    public void shouldShowRegistrationFrom() throws Exception{


        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register")).
                andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
}