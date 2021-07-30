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

	public Reimb selectByName(int name) {
		Session ses = HibernateUtil.getSession();
		List<Reimb> user = ses
				.createNativeQuery("SELECT * FROM ers_reimbursement WHERE Reinb_ID='" + name + "'", Reimb.class).list();
		return user.get(0);
	}

	public Reimb selectBynameHQL(boolean b) {

		Session ses = HibernateUtil.getSession();
		List<Reimb> user = ses.createNativeQuery("FROM ers_reimbursement WHERE submitted="+b,
				Reimb.class).list();
		return user.get(0);
	}

	public void update(Reimb user) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(user);
		tx.commit();
	}

	public List<Reimb> selectAll() {

		Session ses = HibernateUtil.getSession();
		List<Reimb> user = ses.createQuery("from ers_reimbursement", Reimb.class).list();
		return user;
	}
}