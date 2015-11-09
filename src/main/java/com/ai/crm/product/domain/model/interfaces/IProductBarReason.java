package com.ai.crm.product.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IProductBarReason extends IInstanceEntity{
	enum BarCode {
		APPLIED_ONE_WAY_BAR(1),
		APPLIED_TWO_WAY_BAR(2),
		MANAGED_ONE_WAY_BAR(3),
		MANAGED_TWO_WAY_BAR(4),
		OVERDUE_PAYMENT_ONE_WAY_BAR(5),
		OVERDUE_PAYMENT_TWO_WAY_BAR(6),
		PRE_CLOSE_BAR(7),
		CLOSE_BAR(8);
		private int value; 
	    private BarCode(int value){ 
	        this.value=value; 
	    } 
 
	    public int getValue(){ 
	        return value; 
	    } 
	}
	
	int getBarCode();
	void setBarCode(int barCode);
	IProduct getProduct();
	void setProduct(IProduct product);
}
