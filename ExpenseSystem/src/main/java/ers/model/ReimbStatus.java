package ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ers.enums.ReimbStatusEnum;

@Entity
@Table(name = "ers_reimbursement_status")
public class ReimbStatus{
	
	@Id
	@Enumerated(EnumType.STRING)
	@Column(name="reimb_status",length = 16)
	private ReimbStatusEnum status;


	public ReimbStatus() {
		super();
	}
	
	

	public ReimbStatus(ReimbStatusEnum status) {
		super();
		this.status = status;
	}



	public ReimbStatusEnum getStatus() {
		return status;
	}


	public void setStatus(ReimbStatusEnum status) {
		this.status = status;
	}

	
}
