package ers.service;

import java.util.Date;

import ers.dao.RequestDAO;
import ers.enums.ReimbStatusEnum;
import ers.enums.ReimbTypeEnum;
import ers.model.Reimb;
import ers.model.ReimbStatus;
import ers.model.ReimbType;
import ers.model.Users;

public class Request {

	Users u = new Users();
	RequestDAO rdao = new RequestDAO();
	ReimbType rt = new ReimbType();
	ReimbStatus stat = new ReimbStatus();
	
	public void submitRequest(Users u, Reimb r, String reason) {
		r.setSubmit(u);
		stat.setStatus(ReimbStatusEnum.PENDING);
		r.setStatus(stat);

		try {
		switch (reason) {
		case "Lodging":
			rt.setType(ReimbTypeEnum.LODGING);
			r.setType(rt);
			break;
		case "Travel":
			rt.setType(ReimbTypeEnum.TRAVEL);
			r.setType(rt);
			break;
		case "Food":
			rt.setType(ReimbTypeEnum.FOOD);
			r.setType(rt);
			break;
		default:
			rt.setType(ReimbTypeEnum.OTHER);
			r.setType(rt);
			break;
		}
		}catch (Exception e) {
		}
		
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
