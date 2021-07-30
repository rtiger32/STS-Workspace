package ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement")
public class Reimb {

	@Column(name = "reimb_amount", nullable = false)
	private double amount;
	@Column(name = "reimb_submitted", nullable = false)
	private boolean submitted;
	@Column(name = "reimb_resolved", nullable = false)
	private boolean resolved;
	@Column(name = "reimb_description", nullable = false)
	private String description;
	@Column(name = "reimb_reciept", nullable = false)
	private boolean reciept;
	@Id
	@Column(name = "Reimb_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_submitted", referencedColumnName = "ers_username")
	private Users fname;

	@ManyToOne
	@JoinColumn(name = "user_resolved", referencedColumnName = "ers_username")
	private Users lname;

	@ManyToOne
	@JoinColumn(name = "reimb_type", referencedColumnName = "reimb_type")
	private ReimbType type;

	@ManyToOne
	@JoinColumn(name = "reimb_status", referencedColumnName = "reimb_status")
	private ReimbStatus status;

	public Reimb(double amount, boolean submitted, boolean resolved, String description) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
	}

	public Reimb() {
		super();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isReciept() {
		return reciept;
	}

	public void setReciept(boolean reciept) {
		this.reciept = reciept;
	}

	@Override
	public String toString() {
		return "Reimbursement [amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", reciept=" + reciept + "]";
	}

}