package ers.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
	@Column(name = "reimb_submitted" )
	private String dateSubmitted;
	@Column(name = "reimb_resolved" )
	private String dateResolved;
	@Column(name = "reimb_description", nullable = false)
	private String description;
	@Column(name = "reimb_reciept")
	private boolean reciept;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Reimb_ID")
	private int id;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_submitted", referencedColumnName = "ers_username")
	private Users submit;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_resolved", referencedColumnName = "ers_username")
	private Users resolve;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "reimb_type", referencedColumnName = "reimb_type")
	private ReimbType type;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "reimb_status", referencedColumnName = "reimb_status")
	private ReimbStatus status;

	public Reimb(double amount, String description) {
		super();
		String date = new Date().toString();
		this.amount = amount;
		this.dateSubmitted = date;
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

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
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

	public Users getSubmit() {
		return submit;
	}

	public void setSubmit(Users submit) {
		this.submit = submit;
	}

	public Users getResolve() {
		return resolve;
	}

	public void setResolve(Users resolve) {
		this.resolve = resolve;
	}

	public ReimbType getType() {
		return type;
	}

	public void setType(ReimbType type) {
		this.type = type;
	}

	public ReimbStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbStatus status) {
		this.status = status;
	}

}