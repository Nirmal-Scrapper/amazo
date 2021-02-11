<%@page 
import="java.util.Date" 
autoFlush="true" 
buffer="1kb" 
errorPage="err.jsp"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
isThreadSafe="false"    
    
%>
<%@include file="header.jsp" %>
<jsp:include page="header.jsp">
	<jsp:param name="cname" value=" AMAZON...."/>
</jsp:include>

<%-- <%
	RequestDispatcher rd=request.getRequestDispatcher("header.jsp?cname=amazon");
	rd.forward(request,response);

%> --%>
<jsp:forward page="header.jsp">
	<jsp:param name="cname" value=" AMAZON...."/>
</jsp:forward>

<%=application.getRealPath("") %>
<%
	for(int i=0;i<100;i++){
		out.print("Hello world");
	}
	


%>
காலை வணக்கம்