package com.company.pickmyparcel.controller;

import com.company.pickmyparcel.model.PriceMaintenance;
import com.company.pickmyparcel.service.PriceMaintenenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priceMaintenance")
public class PriceMaintenanceController {

    @Autowired
    private PriceMaintenenceService priceMaintenenceService;


    @PostMapping("/")
    ResponseEntity<PriceMaintenance> savePriceDetails(@RequestBody PriceMaintenance priceMaintenance) {
        PriceMaintenance response = priceMaintenenceService.savePriceDetails(priceMaintenance);
        return ResponseEntity.ok(response);
    }

}
