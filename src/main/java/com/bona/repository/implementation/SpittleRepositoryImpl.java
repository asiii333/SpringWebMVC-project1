package com.bona.repository.implementation;

import com.bona.data.Spittle;
import com.bona.repository.SpittleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Asia on 2015-12-23.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittlesList = new ArrayList<Spittle>(20);
        for(int i =0; i<count; i++){
            spittlesList.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittlesList;
    }

    public Spittle findOne(long id) {
        return new Spittle("Hello! its spitlle number: " + id, new Date());
    }
}
