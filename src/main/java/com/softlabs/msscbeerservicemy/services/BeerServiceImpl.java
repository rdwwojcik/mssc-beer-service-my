package com.softlabs.msscbeerservicemy.services;

import com.softlabs.msscbeerservicemy.web.model.BeerDto;
import com.softlabs.msscbeerservicemy.web.model.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID uuid, BeerDto beerDto) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
