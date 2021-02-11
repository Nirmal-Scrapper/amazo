package model;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String language=request.getParameter("lang");
		
		Locale locale=new Locale(language);
		
		ResourceBundle rb=ResourceBundle.getBundle("utility.Dictionary",locale);
		
		HttpSession session=request.getSession();
		session.setAttribute("rb", rb);
		
		return "lang.success";
	}
}
