package com.kaamcube.truelysell.service.impl;

import com.kaamcube.truelysell.model.entity.Subscription;
import com.kaamcube.truelysell.model.entity.SubscriptionsPlan;
import com.kaamcube.truelysell.model.request.AddSubscriptionsRequest;
import com.kaamcube.truelysell.model.responce.Response;
import com.kaamcube.truelysell.repository.SubscriptionsPlanRepo;
import com.kaamcube.truelysell.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    private SubscriptionsPlanRepo subscriptionsPlanRepo;

    @Override
    public Response getSubscriptionsPlan() {
        Response response = null;
        try {
            List<SubscriptionsPlan> subscriptionsPlans = subscriptionsPlanRepo.findAll();
            response = new Response("Success", "200", "Subscriptions Plans List ", subscriptionsPlans);
        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response addSubscriptionPlans(AddSubscriptionsRequest addSubscriptionsRequest) {
        Response response = null;
        try {
            SubscriptionsPlan subscriptionsPlan = new SubscriptionsPlan();
            subscriptionsPlan.setPlanName(addSubscriptionsRequest.getPlanName());
            subscriptionsPlan.setAmount(addSubscriptionsRequest.getAmount());
            subscriptionsPlan.setDuration(addSubscriptionsRequest.getDuration());
            subscriptionsPlan.setExpiration(addSubscriptionsRequest.getDuration());
            subscriptionsPlan.setActive(true);
            subscriptionsPlan.setCreatedAt(LocalDateTime.now().toString());
            SubscriptionsPlan subscriptionsPlanData = subscriptionsPlanRepo.save(subscriptionsPlan);
            response = new Response("Success", "201", "Add Subscriptions Plans Successfully ", subscriptionsPlanData);
        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }
}
