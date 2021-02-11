package model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserBuisness;

public class LoginAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");

		ActionErrors errors=new ActionErrors();
		Set<ActionError> set=new HashSet<>();
		if(uname==null || uname.length()==0) {
			RequiredActionError req=new RequiredActionError("Username is compulsory....");
			set.add(req);
			errors.setError(set);
			request.setAttribute("errors", errors);
			return "login.error";
		}
		int id=new UserBuisness().Login(uname, upass);
		if(id==0) {
			RequiredActionError req=new RequiredActionError("invalid is credentials....");
			set.add(req);
			errors.setError(set);
			request.setAttribute("errors", errors);
			return "login.error";
		}
		HttpSession session=request.getSession();
		session.setAttribute("uname", String.valueOf(id));
		if(session.getAttribute("rb") != null)
			session.removeAttribute("rb");
		return "login.success";
	}
}
