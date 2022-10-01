package com.company.pickmyparcel.service;

import com.company.pickmyparcel.model.PriceMaintenance;
import com.company.pickmyparcel.repository.PriceMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceMaintenanceServiceImpl implements PriceMaintenenceService {

    @Autowired
    private PriceMaintenanceRepository priceMaintenanceRepository;

    @Override
    public PriceMaintenance savePriceDetails(PriceMaintenance priceMaintenance) {
        return priceMaintenanceRepository.save(priceMaintenance);
    }
}
