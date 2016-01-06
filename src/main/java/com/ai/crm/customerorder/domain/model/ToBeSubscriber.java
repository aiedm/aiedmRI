package com.ai.crm.customerorder.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.Subscriber;

@Entity
@Table(name="PD_SUBSCRIBER")
public class ToBeSubscriber extends Subscriber{
	@OneToMany(mappedBy="subscriber",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ToBeNetworkProduct> products=new HashSet<ToBeNetworkProduct>();

	
	public Set<ToBeNetworkProduct> getProducts() {
		return products;
	}

	
	public void addProduct(ToBeNetworkProduct product) {
		if (null!=product){
			products.add(product);
			if (null==product.getSubscriber()){
				product.setSubscriber(this);
			}
		}

	}
}
