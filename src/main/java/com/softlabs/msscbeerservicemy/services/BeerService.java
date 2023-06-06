package com.softlabs.msscbeerservicemy.services;

import com.softlabs.msscbeerservicemy.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID uuid, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}