package ers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ers.model.Users;
import ers.util.HibernateUtil;

public class UserDAO {

	public void insert(Users user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
	}
	public Users select(int id) {
		Session ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, id);
		return user;
	}
	public Users selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		List<Users> user = ses
				.createNativeQuery("SELECT * FROM ers_users WHERE ers_username='" + name + "'", Users.class).list();
		return user.get(0);
	}

/*	public Users selectBynameHQL(String name) {

		Session ses = HibernateUtil.getSession();
		List<Users> user = ses.createNativeQuery("FROM ers_users WHERE ers_username='" + name + "'", Users.class)
				.list();
		return user.get(0);
	}*/
	public void update(Users user) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(user);
		tx.commit();
	}
	public List<Users> selectAll(){

		Session ses = HibernateUtil.getSession();
		List<Users> user= ses.createQuery("from ers_users", Users.class).list();
		return user;
	}
}