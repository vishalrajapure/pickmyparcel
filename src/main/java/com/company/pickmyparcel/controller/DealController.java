package com.company.pickmyparcel.controller;

import com.company.pickmyparcel.model.Deal;
import com.company.pickmyparcel.model.DealResponse;
import com.company.pickmyparcel.model.requests.SearchDealsRequest;
import com.company.pickmyparcel.service.DealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deals")
@CrossOrigin(origins = "*")
public class DealController {
    @Autowired
    private DealServiceImpl dealServiceimpl;

    @PostMapping("/submitDeal")
    public ResponseEntity<Deal> submitDeal(@RequestBody @Valid Deal deal) {
        Deal deal1 = dealServiceimpl.submitDeal(deal);
        return ResponseEntity.ok(deal1);
    }

    @PostMapping("/searchDeals")
    public ResponseEntity<List<Deal>> searchDeals(@RequestBody @Valid SearchDealsRequest searchDealsRequest) {
        List<Deal> deals = dealServiceimpl.searchDeals(searchDealsRequest);
        return ResponseEntity.ok(deals);
    }


    @PostMapping("/requestForConfirmation")
    public ResponseEntity<Deal> acceptDeal(@RequestBody @Valid Deal dealConfirmationRequest) {
        Deal deal = dealServiceimpl.requestSenderForConfirmation(dealConfirmationRequest);
        return ResponseEntity.ok(deal);
    }

    @GetMapping("/getdealbydealid")
    public Deal getDealByDealId(@RequestParam("dealId") Integer dealId) {
        return dealServiceimpl.getDealByDealId(dealId);
    }

    @GetMapping("/getDealsByContactNumber")
    public ResponseEntity<DealResponse> getDealByContactNumber(@RequestParam("contactNumber") String contactNumber) {
        DealResponse dealListByContactNumber = dealServiceimpl.getDealByContactNumber(contactNumber);
        return ResponseEntity.ok(dealListByContactNumber);
    }

    @GetMapping("/updateParcelStatus")
    public ResponseEntity<Deal> updateParcelStatus(@RequestParam("dealId") Integer dealId, String parcelStatus) {
        Deal deal = dealServiceimpl.updateParcelStatus(dealId, parcelStatus);
        if (deal != null) {
            return ResponseEntity.ok(deal);
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @GetMapping("/verifyOTPAndCompleteDeal")
    public ResponseEntity<Boolean> verifyOTPAndCompleteDeal(@RequestParam("dealId") Integer dealId, @RequestParam("otp") String otp) {
        Boolean result = dealServiceimpl.verifyReceiverOTP(dealId, otp);
        if (result) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.internalServerError().body(false);
        }
    }
}
