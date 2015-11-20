package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.ProductCharacter;

@Entity
@Table(name="ORD_TOBE_PRODUCT_CHARACTER")
public class ToBeProductCharacter extends ProductCharacter {

}
