package com.bona.repository.implementation;

import com.bona.data.Spitter;
import com.bona.repository.SpitterRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Asia on 2015-12-30.
 */
@Component
public class SpitterRepositoryImpl implements SpitterRepository {
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    public Spitter findByUser(String username) {
        return new Spitter("Imie","Nazwisko","imnaz","passy");
    }
}
