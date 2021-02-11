<%@page import="model.LoginFormBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		LoginFormBean formbean=(LoginFormBean)session.getAttribute("formbeanObj");
		out.println(formbean.getUname()+":"+formbean.getUpass());
	
	%> 
<%-- 	<jsp:useBean id="formbeanObj" class="model.LoginFormBean" scope="session">
	<jsp:getProperty name="formbeanObj" property="uname" />
	<jsp:getProperty name="formbeanObj" property="upass"/>
	</jsp:useBean> --%>
	
	
</body>
</html>