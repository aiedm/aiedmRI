package com.ai.upc.priceplan.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComponentPricePlan extends PricePlan {
	private Set<PricePlan> children=new LinkedHashSet<PricePlan>();
	public ComponentPricePlan() {
	}
	
	public Set<PricePlan> getChildPricePlans(){
		return children;
	}
	
	public void addChildPricePlan(PricePlan pricePlan){
		if (null!=pricePlan){
			this.children.add(pricePlan);
		}
	}

}
