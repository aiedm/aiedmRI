package com.ai.crm.common.businessinteractionspec.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecificationEntity;
@Entity
@Table(name="BI_BIZINTERACTION_ITEM_SPEC")
public class BusinessInteractionItemSpec extends SpecificationEntity{
	private long biiSpecId;
	@ManyToOne
	private BusinessInteractionSpec biSpec;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="businessInteractionItemSpec")
	private Set<BIISpecCharacter> characteristSpecs=new LinkedHashSet<BIISpecCharacter>();
	
	public Set<BIISpecCharacter> getCharacteristSpecs(){
		return this.characteristSpecs;
	}
	
	public void addCharacteristSpec(BIISpecCharacter characteristSpec){
		if (null!=characteristSpec){
			this.characteristSpecs.add(characteristSpec);
			if (null==characteristSpec.getBusinessInteractionItemSpec()){
				characteristSpec.setBusinessInteractionItemSpec(this);
			}
		}
	}
	
	public long getBusinessInteractionItemSpecId() {
		return this.biiSpecId;
	}

	
	public void setBusinessInteraciotnItemSpecId(long biiSpecId) {
		this.biiSpecId=biiSpecId;
	}

	
	public BusinessInteractionSpec getBusinessInteractionSpec() {
		return this.biSpec;
	}

	
	public void setBusinessInteractionSpec(BusinessInteractionSpec biSpec) {
		this.biSpec=biSpec;
	}

}
