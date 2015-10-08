package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.flyingshuttle.base.service.impl.CheckResult;

public interface ICheckCreateCustomerOrder {
	CheckResult checkCreateNewOrderCustomerAvalibity(ICustomerOrder customerOrder) throws Exception;
	CheckResult checkCreateNewOfferOrderAvalibity(IOfferOrderItem offerOrder) throws Exception;
	CheckResult checkCreateNewProductOrderAvalibity(IProductOrderItem productOrder) throws Exception;
}
