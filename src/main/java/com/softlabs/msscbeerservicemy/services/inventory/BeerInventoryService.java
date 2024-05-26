package com.softlabs.msscbeerservicemy.services.inventory;

import java.util.UUID;

/**
 * Created by radek on 2023-06-23
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
