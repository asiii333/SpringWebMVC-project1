package com.bona.repository;

import com.bona.data.Spittle;

import java.util.List;

/**
 * Created by Asia on 2015-12-20.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);
}
