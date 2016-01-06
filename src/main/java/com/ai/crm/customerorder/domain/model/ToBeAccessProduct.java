package com.ai.crm.customerorder.domain.model;

import java.util.Set;
public class ToBeAccessProduct extends ToBeNetworkProduct {
	private String[] serialCharacterSpecCodes=new String[]{"NUMBER","ACCOUNT"};
	public ToBeAccessProduct() {
		
	}

	public String getSerialNo() throws Exception{
		String number=null;
		Set<ToBeProductCharacter> asIsProductCharacters=this.getProductCharacters();
		if (null!=asIsProductCharacters&&asIsProductCharacters.size()>0){
			for (ToBeProductCharacter asIsProductCharacter : asIsProductCharacters) {
				if (this.getSerialCharacterSpecCodes().toString().contains(asIsProductCharacter.getCharacteristicSpec().getCode())){
					number=this.getInstEntityCharValue(asIsProductCharacter, 0);
					break;
				}
			}
		}		
		return number;
	}

	public String[] getSerialCharacterSpecCodes() {
		return serialCharacterSpecCodes;
	}
	

	public void setSerialCharacterSpecCodes(String[] serialCharacterSpecCodes) {
		this.serialCharacterSpecCodes = serialCharacterSpecCodes;
	}
	
}
