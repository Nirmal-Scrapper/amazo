<%@page import="model.LoginFormBean"%>
<%-- <%
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");

	LoginFormBean formbeanObj=new LoginFormBean();
	formbeanObj.setUname(uname);
	formbeanObj.setUpass(upass);
	
	session.setAttribute("formbeanObj", formbeanObj);
	
%> --%>
<jsp:useBean id="formbeanObj" class="model.LoginFormBean" scope="session">
	<jsp:setProperty name="formbeanObj" property="*"/>
	<%-- <jsp:setProperty name="formbeanObj" property="upass"/> --%>
</jsp:useBean>

<jsp:forward page="next.jsp"/>

