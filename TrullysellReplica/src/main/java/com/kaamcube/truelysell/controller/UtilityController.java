package com.kaamcube.truelysell.controller;

import com.kaamcube.truelysell.model.request.AddSubscriptionsRequest;
import com.kaamcube.truelysell.model.responce.Response;
import com.kaamcube.truelysell.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilityController {

    @Autowired
    private UtilityService utilityService;
    @PostMapping("/addSubscriptionPlans")
    public Response addSubscriptionPlans(@RequestBody AddSubscriptionsRequest addSubscriptionsRequest){
        return utilityService.addSubscriptionPlans(addSubscriptionsRequest);
    }
    @GetMapping("/getSubscriptionPlans")
    public Response getSubscriptionPlans(){
        return utilityService.getSubscriptionsPlan();
    }
}
