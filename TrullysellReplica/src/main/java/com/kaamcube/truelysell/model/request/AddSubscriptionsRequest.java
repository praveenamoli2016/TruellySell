package com.kaamcube.truelysell.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kaamcube.truelysell.utility.enums.PaymentMethod;
import com.kaamcube.truelysell.utility.enums.Plan;
import com.kaamcube.truelysell.utility.enums.Status;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddSubscriptionsRequest {
    private Plan planName;
    private Long duration;;
    private Double amount;
}
