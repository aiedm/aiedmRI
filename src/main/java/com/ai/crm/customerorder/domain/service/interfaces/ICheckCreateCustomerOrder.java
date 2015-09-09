package com.ai.crm.customerorder.domain.service.interfaces;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.flyingshuttle.base.service.impl.CheckResult;

public interface ICheckCreateCustomerOrder {
	CheckResult checkCreateNewOrderCustomerAvalibity(ICustomerOrder customerOrder);
	CheckResult checkCreateNewOfferOrderAvalibity(IOfferOrder offerOrder);
	CheckResult checkCreateNewProductOrderAvalibity(IProductOrder productOrder);
}
