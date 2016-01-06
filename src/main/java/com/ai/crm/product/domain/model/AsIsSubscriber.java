package com.ai.crm.product.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.crm.customerorder.domain.model.ToBeNetworkProduct;

@Entity
@Table(name="PD_SUBSCRIBER")
public class AsIsSubscriber extends Subscriber{
	@OneToMany(mappedBy="subscriber",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<AsIsNetworkProduct> products=new HashSet<AsIsNetworkProduct>();

	
	public Set<AsIsNetworkProduct> getProducts() {
		return products;
	}

	
	public void addProduct(AsIsNetworkProduct product) {
		if (null!=product){
			products.add(product);
			if (null==product.getSubscriber()){
				product.setSubscriber(this);
			}
		}

	}
}
