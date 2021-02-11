package model;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String shopid = request.getParameter("shopid");
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String name = en.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + ":" + value);
			int flag = 0;
			for (char c : value.toCharArray()) {
				if (!Character.isDigit(c)) {
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				session.setAttribute(name, value);
			else {
				if (Integer.parseInt(value)>0) {
					//session.setAttribute(name, value);
					new ShoppingAction().lateAdd(session,name,value);
				}
			}

		}
		return shopid;
	}
	public void lateAdd(HttpSession session,String name,String value) {
		try {
			Thread.sleep(20);
			session.setAttribute(name, value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
