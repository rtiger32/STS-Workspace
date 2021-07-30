package ers.util;

import org.hibernate.Session;

public class SessionUtil {
	Session ses;
	public void getSession() {
		ses = HibernateUtil.getSession();
	}
	
	public void close() {
		ses.close();
	}
}
