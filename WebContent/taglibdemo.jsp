<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="myjsp" uri="/WEB-INF/codatags.tld" %>
<body>
	<%-- <%
		int n=Integer.parseInt(request.getParameter("num"));
		if(n%2==0){
			out.println("<h1>Even number...</h1>");
		}
		else{
			out.println("<h1>Odd Number...</h1>");
		}
	%> --%>
	
	<myjsp:checkNumber num="<%=request.getParameter(\"num\")%>"/>
	
	
</body>
</html>