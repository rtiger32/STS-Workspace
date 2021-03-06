package ers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ers.model.Reimb;
import ers.util.HibernateUtil;

public class RequestDAO {

	public void insert(Reimb rb) {
		// add a new record
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(rb);
		tx.commit();
	}

	public Reimb select(int id) {
		Session ses = HibernateUtil.getSession();
		Reimb rb = ses.get(Reimb.class, id);
		return rb;
	}

	public void update(Reimb rb) {
		// update a record
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(rb);
		tx.commit();
	}

	public List<Reimb> selectUnresolved(String name) {
		// View all pending requests of all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery(
				"FROM Reimb WHERE user_submitted='" + name + "' AND  reimb_status='PENDING'", Reimb.class)
				.list();
		return rb;
	}

	public List<Reimb> selectResolved(String name) {
		// View all resolved requests of all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery(
				"FROM Reimb WHERE user_submitted='" + name + "' AND NOT reimb_status='PENDING'",
				Reimb.class).list();
		return rb;
	}

	public List<Reimb> selectAll(String name) {
		// View reimbursement requests of a specific employee
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses
				.createQuery("FROM Reimb WHERE user_submitted='" + name + "'", Reimb.class).list();
		return rb;
	}

	public List<Reimb> selectUnresolved() {
		// View all pending requests of all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery("FROM Reimb WHERE reimb_status='PENDING'", Reimb.class)
				.list();
		return rb;
	}

	public List<Reimb> selectResolved() {
		// View all resolved requests of all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery("FROM Reimb WHERE NOT reimb_status='PENDING'", Reimb.class)
				.list();
		return rb;
	}

	public List<Reimb> selectAll() {
		// View all employees requests
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery("from Reimb", Reimb.class).list();
		return rb;
	}
}