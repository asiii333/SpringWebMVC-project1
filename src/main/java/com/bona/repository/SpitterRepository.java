package com.bona.repository;

import com.bona.data.Spitter;

/**
 * Created by Asia on 2015-12-30.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUser(String username);
}
