package com.softlabs.msscbeerservicemy.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softlabs.msscbeerservicemy.bootstrap.BeerLoader;
import com.softlabs.msscbeerservicemy.services.BeerService;
import com.softlabs.msscbeerservicemy.web.model.BeerDto;
import com.softlabs.msscbeerservicemy.web.model.BeerStyleEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by radek on 2023-06-09
 */
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        reset(beerService);
    }

    @Test
    void getBeerById() throws Exception {
        when(beerService.getBeerById(any())).thenReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = this.getValidBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        beerDto.setId(UUID.randomUUID());
        when(beerService.saveNewBeer(any())).thenReturn(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        when(beerService.updateBeer(any(), any())).thenReturn(getValidBeerDto());

        String beerDtoJson = objectMapper.writeValueAsString(getValidBeerDto());
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("PaniPani")
                .beerStyle(BeerStyleEnum.IPA)
                .upc(BeerLoader.BEER_1_UPC)
                .price(new BigDecimal("8.99"))
                .build();
    }
}