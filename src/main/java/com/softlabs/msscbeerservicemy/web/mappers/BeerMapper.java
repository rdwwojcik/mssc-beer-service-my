package com.softlabs.msscbeerservicemy.web.mappers;

import com.softlabs.msscbeerservicemy.domain.Beer;
import com.softlabs.msscbeerservicemy.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by radek on 2023-06-09
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
