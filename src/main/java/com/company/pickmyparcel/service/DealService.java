package com.company.pickmyparcel.service;

import com.company.pickmyparcel.model.Deal;
import com.company.pickmyparcel.model.DealResponse;
import com.company.pickmyparcel.model.requests.SearchDealsRequest;

import java.util.List;

public interface DealService {
    Deal submitDeal(Deal deal);

    Deal getDealByDealId(Integer id);


    List<Deal> searchDeals(SearchDealsRequest searchDealsRequest);

    Deal requestSenderForConfirmation(Deal acceptDealRequest);

    DealResponse getDealByContactNumber(String contactNumber);

    Deal updateParcelStatus(Integer dealId, String parcelStatus);

    Boolean verifyReceiverOTP(Integer dealId, String otp);
}
