package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PD_PRODUCT_CHARACTER")
public class AsIsProductCharacter extends ProductCharacter {
	@ManyToOne
	private AsIsProduct product;
	@OneToMany(mappedBy="productCharacter")
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
}
