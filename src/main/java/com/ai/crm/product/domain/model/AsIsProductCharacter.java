package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;

@Entity
@Table(name="PD_PRODUCT_CHARACTER")
public class AsIsProductCharacter extends ProductCharacter {
	@ManyToOne
	private AsIsProduct product;
	@OneToMany(mappedBy="productCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<AsIsProductCharacterValue> productCharacterValues=new LinkedHashSet<AsIsProductCharacterValue>();

	public AsIsProductCharacter() {
	}
	public AsIsProduct getProduct() {
		return product;
	}
	public void setProduct(AsIsProduct product) {
		this.product = product;
	}
	public Set<AsIsProductCharacterValue> getproductCharacterValues() {
		return this.productCharacterValues;
	}

	
	public void addproductCharacterValue(AsIsProductCharacterValue characteristicInstanceValue) {
		this.productCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getProductCharacter()){
			characteristicInstanceValue.setProductCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public AsIsProductCharacterValue  newCharacterValue(){
		return new AsIsProductCharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addproductCharacterValue((AsIsProductCharacterValue)characteristicInstanceValue);		
	}
}
