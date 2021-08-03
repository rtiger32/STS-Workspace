package ers.service;

import java.util.ArrayList;
import java.util.List;

import ers.dao.RequestDAO;
import ers.model.Reimb;

public class View {

	private RequestDAO rdao = new RequestDAO();
	private List<Reimb> viewList = new ArrayList<Reimb>();

	public List<Reimb> employeePending(String name) {
		// This method is used to return pending requests by username
		viewList = rdao.selectUnresolved(name);
		return viewList;
	}

	public List<Reimb> employeeResolved(String name) {
		// This method is used to return resolved requests by username
		viewList = rdao.selectResolved(name);
		return viewList;
	}

	public List<Reimb> employeeAll(String name) {
		// This method will be used to fetch the list of requests by username
		viewList = rdao.selectAll(name);
		return viewList;
	}

	public List<Reimb> pending() {
		// This method is used to return all pending requests
		viewList = rdao.selectUnresolved();
		return viewList;
	}

	public List<Reimb> resolved() {
		// This method is used to return all resolved requests
		viewList = rdao.selectResolved();
		return viewList;
	}

	public List<Reimb> all() {
		// This method is used to return all requests
		viewList = rdao.selectAll();
		return viewList;
	}
}
