package com.ai.crm.common.businessinteractionspec.repository.interfaces;

import com.ai.crm.common.businessinteractionspec.domain.model.BusinessInteractionItemSpec;
import com.ai.crm.common.businessinteractionspec.domain.model.BusinessInteractionSpec;

public interface IBusinessInteractionSpecRepository {
	BusinessInteractionSpec getBusinessInteractionSpecById(long biSpecId) throws Exception;
	BusinessInteractionItemSpec getBusinessInteractionItemSpecById(long biiSpecId) throws Exception;
}
