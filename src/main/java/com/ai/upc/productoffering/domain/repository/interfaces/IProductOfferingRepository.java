package com.ai.upc.productoffering.domain.repository.interfaces;

import com.ai.upc.productoffering.domain.model.ProductOffering;

public interface IProductOfferingRepository {
	ProductOffering getProductOfferingById(long productOfferingId) throws Exception;
	ProductOffering getProductOfferingByCode(String productOfferingCode) throws Exception;
}
