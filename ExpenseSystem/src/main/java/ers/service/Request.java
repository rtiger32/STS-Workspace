package ers.service;

import java.util.Date;

import ers.dao.RequestDAO;
import ers.enums.ReimbStatusEnum;
import ers.model.Reimb;
import ers.model.ReimbStatus;
import ers.model.Users;

public class Request {

	Users u = new Users();
	RequestDAO rdao = new RequestDAO();
	
	public void submitRequest(Users u, Reimb r) {
		r.setSubmit(u);
		ReimbStatus stat = new ReimbStatus();
		stat.setStatus(ReimbStatusEnum.PENDING);
		r.setStatus(stat);
		rdao.insert(r);
	}
	
	public void resolveRequest(ReimbStatusEnum status, Users u, Reimb r) {
		r.setResolve(u);
		r.setDateResolved(new Date().toString());
		ReimbStatus stat = new ReimbStatus();
		stat.setStatus(status);
		r.setStatus(stat);
		rdao.update(r);
		
	}
	
}
