package com.ai.upc.productoffering.domain.repository.interfaces;

import com.ai.upc.productoffering.domain.model.interfaces.IProductOffering;

public interface IProductOfferingRepository {
	IProductOffering getProductOfferingById(long productOfferingId) throws Exception;
	IProductOffering getProductOfferingByCode(String productOfferingCode) throws Exception;
}
