package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;

@MappedSuperclass
public class ProductCharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private Product product;
	@OneToMany(mappedBy="productCharacter")
	private Set<ProductCharacterValue> productCharacterValues=new LinkedHashSet<ProductCharacterValue>();

	public ProductCharacter() {
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Set<ProductCharacterValue> getproductCharacterValues() {
		return this.productCharacterValues;
	}

	
	public void addproductCharacterValue(ProductCharacterValue characteristicInstanceValue) {
		this.productCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getProductCharacter()){
			characteristicInstanceValue.setProductCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new ProductCharacterValue();
	}
}
