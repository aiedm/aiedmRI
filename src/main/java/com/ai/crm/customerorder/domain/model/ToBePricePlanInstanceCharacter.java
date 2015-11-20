package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.PricePlanInstanceCharacter;
@Entity
@Table(name="ORD_TOBE_PRICE_CHARACTER")
public class ToBePricePlanInstanceCharacter extends PricePlanInstanceCharacter {

}
