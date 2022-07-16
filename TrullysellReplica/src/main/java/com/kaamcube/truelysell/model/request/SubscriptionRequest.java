package com.kaamcube.truelysell.model.request;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kaamcube.truelysell.model.entity.SubscriptionsPlan;
import com.kaamcube.truelysell.model.entity.Vendor;
import com.kaamcube.truelysell.utility.enums.PaymentMethod;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionRequest {

    private Long vendorId;
    private Long planId;
    private PaymentMethod paymentMethod;

}
