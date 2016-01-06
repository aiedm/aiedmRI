package com.ai.upc.productspecification.domian.model;

import java.util.Set;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

public class ProductLine extends SpecificationEntity{

	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	
	public long getProductLineId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void setProductLineId() {
		// TODO Auto-generated method stub

	}

	
	public AccessProductSpecification getAccessProductSpec() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setAccessProduct(AuxiliaryProductSpecification accessProductSpec) {
		// TODO Auto-generated method stub

	}

	
	public Set<AuxiliaryProductSpecification> getAttachingProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addAttachingProductSpec(AuxiliaryProductSpecification AttachingProductSpec) {
		// TODO Auto-generated method stub

	}

	
	public Set<ProductSpecification> getContainedProductSpecs() {
		// TODO Auto-generated method stub
		return null;
	}

}
