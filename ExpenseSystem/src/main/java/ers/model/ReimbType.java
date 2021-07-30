package ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ers.enums.ReimbTypeEnum;

@Entity
@Table(name = "ers_reimbursement_type")
public class ReimbType {

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name="reimb_type",length = 16)
	private ReimbTypeEnum type;


	public ReimbType() {
		super();
	}


	


	public ReimbTypeEnum getType() {
		return type;
	}


	public void setType(ReimbTypeEnum type) {
		this.type = type;
	}

	
}
