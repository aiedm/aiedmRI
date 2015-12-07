package com.ai.crm.customerorder.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.crm.product.domain.model.ProductCharacter;

@Entity
@Table(name="ORD_TOBE_PRODUCT_CHARACTER")
public class ToBeProductCharacter extends ProductCharacter {
	@ManyToOne
	private ToBeProduct product;
	@OneToMany(mappedBy="productCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<ToBeProductCharacterValue> productCharacterValues=new LinkedHashSet<ToBeProductCharacterValue>();

	public ToBeProductCharacter() {
	}
	public ToBeProduct getProduct() {
		return product;
	}
	public void setProduct(ToBeProduct product) {
		this.product = product;
	}
	public Set<ToBeProductCharacterValue> getproductCharacterValues() {
		return this.productCharacterValues;
	}

	
	public void addProductCharacterValue(ToBeProductCharacterValue characteristicInstanceValue) {
		this.productCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getProductCharacter()){
			characteristicInstanceValue.setProductCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public ToBeProductCharacterValue  newCharacterValue(){
		return new ToBeProductCharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addProductCharacterValue((ToBeProductCharacterValue)characteristicInstanceValue);		
	}
}
