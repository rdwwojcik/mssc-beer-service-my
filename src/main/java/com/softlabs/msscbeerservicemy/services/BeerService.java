package com.softlabs.msscbeerservicemy.services;

import com.softlabs.msscbeerservicemy.web.model.BeerDto;
import com.softlabs.msscbeerservicemy.web.model.BeerPagedList;
import com.softlabs.msscbeerservicemy.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID uuid, BeerDto beerDto);

}
