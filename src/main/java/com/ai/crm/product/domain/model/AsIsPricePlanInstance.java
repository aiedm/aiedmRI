package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PD_PRICE_INS")
public class AsIsPricePlanInstance extends PricePlanInstance {

}
