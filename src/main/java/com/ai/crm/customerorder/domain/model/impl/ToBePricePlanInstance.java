package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.SpecificationInstanceEntity;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.product.domain.model.impl.PricePlanInstance;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ToBePricePlanInstance extends PricePlanInstance implements IToBePricePlanInstance {


}
