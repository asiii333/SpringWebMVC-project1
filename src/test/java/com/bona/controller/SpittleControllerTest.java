package com.bona.controller;

import com.bona.data.Spittle;
import com.bona.repository.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.internal.matchers.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Asia on 2015-12-20.
 */
public class SpittleControllerTest {

    private SpittleRepository repository = mock(SpittleRepository.class);
    private SpittleController controller = new SpittleController(repository);

    @Test
    public void testSpittles() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        when(repository.findOne(12345l)).thenReturn(expectedSpittle);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spittles/12345"))
        .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    @Test
    public void shouldReturnRecentSplites() throws Exception{

        int splittNumber = 20;
        List<Spittle> expectedSpittles = createSplitleList(splittNumber);
        when(repository.findSpittles(Long.MAX_VALUE,splittNumber)).thenReturn(expectedSpittles);

        MockMvc mock = standaloneSetup(controller).
                setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp")
                ).build();
        mock.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }



    private List<Spittle> createSplitleList(int count) {
        List<Spittle> spittlesList = new ArrayList<Spittle>(20);
        for(int i =0; i<count; i++){
            spittlesList.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittlesList;

    }
}