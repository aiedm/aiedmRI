package com.ai.crm.common.businessinteractionspec.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteractionspec.domain.model.BusinessInteractionItemSpec;
import com.ai.crm.common.businessinteractionspec.domain.model.BusinessInteractionSpec;
import com.ai.crm.common.businessinteractionspec.repository.interfaces.IBusinessInteractionSpecRepository;
@Component
public class BusinessInteractionSpecRepository implements IBusinessInteractionSpecRepository {

	public BusinessInteractionSpecRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BusinessInteractionSpec getBusinessInteractionSpecById(long biSpecId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessInteractionItemSpec getBusinessInteractionItemSpecById(long biiSpecId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
