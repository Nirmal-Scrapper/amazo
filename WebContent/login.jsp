<!DOCTYPE html>
<%@page import="model.ActionError"%>
<%@page import="java.util.Set"%>
<%@page import="model.ActionErrors"%>
<%@page import="java.util.ResourceBundle" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ActionErrors errors=(ActionErrors)request.getAttribute("errors");
	if(errors!=null){
		Set<ActionError> setOfErrors=errors.getError();
		for(ActionError ae:setOfErrors){
			out.println("<h3 style=red>"+ae.error()+"</h3>");
		}
	}
	ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
%>
	<form action="login.do" method="post">
	<input type="hidden" name="formid" value="login">
		<%=rb.getString("username")%>:<input type="text" name="uname">
		<%=rb.getString("password")%>:<input type="password" name="upass">
		
		<input type="submit" value="submit">
	</form>
</body>
</html>