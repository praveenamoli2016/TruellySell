package com.kaamcube.truelysell.service;

import com.kaamcube.truelysell.model.request.AddSubscriptionsRequest;
import com.kaamcube.truelysell.model.responce.Response;

public interface UtilityService {
    Response getSubscriptionsPlan();

    Response addSubscriptionPlans(AddSubscriptionsRequest addSubscriptionsRequest);
}
