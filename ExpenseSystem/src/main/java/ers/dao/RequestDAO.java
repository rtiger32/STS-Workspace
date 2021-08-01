package ers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ers.model.Reimb;
import ers.util.HibernateUtil;

public class RequestDAO {

	public void insert(Reimb rb) {
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

	public List<Reimb> selectBySubmitName(String name) {
		// View reimbursement requests of a specific employee
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses
				.createNativeQuery("FROM ers_reimbursement WHERE user_submitted='" + name + "'", Reimb.class).list();
		return rb;
	}
	
	public List<Reimb> selectUnresolved(String name) {
		// View all pending requests of all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses
				.createNativeQuery("FROM ers_reimbursement WHERE reimb_status='PENDING'", Reimb.class).list();
		return rb;
	}
		public List<Reimb> selectResolved(String name) {
			//View all resolved requests of all employees
			Session ses = HibernateUtil.getSession();
			List<Reimb> rb = ses
					.createNativeQuery("FROM ers_reimbursement WHERE NOT reimb_status='PENDING'", Reimb.class).list();
			return rb;
	}
	

	public void update(Reimb rb) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(rb);
		tx.commit();
	}

	public List<Reimb> selectAll() {
		//View all employees
		Session ses = HibernateUtil.getSession();
		List<Reimb> rb = ses.createQuery("from ers_reimbursement", Reimb.class).list();
		return rb;
	}
}