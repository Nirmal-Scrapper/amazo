<%@page import="item.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="red">
	<hr>
	<%@ include file="logout.jsp"%>
	<h3>
		Welcome Mr..<%=session.getAttribute("uname")%></h3>
	<hr>
	<h1>Vegetable shop</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping"> <input
			type="hidden" name="shopid" value="shop1">
		<%
		String items[][] = new ItemDAO().ReadAll();
		for (int i = 0; i < 3 && i < items.length / 3; i++) {

			//System.out.print("<input type=checkbox name='" + items[i][0] + "' value='" + items[i][1] + "'>" + items[i][1]);
			out.println("<img src='" + items[i][3] + "' alt='" + items[i][0] + "' style='width:50px;height:50px'/>");

			int limit = Integer.parseInt(items[i][2]);
			if (limit > 10) {
				limit = 10;
			}
			out.println("<input type=checkbox name='" + items[i][0] + "' value='" + items[i][1] + "'>" + items[i][1]);

			out.println("  <input type='range' name='" + items[i][0] + "quan' min='0' max='" + limit + "' value='0' class='slider' id='" + items[i][0]
			+ "'> <br>");
			out.println(" <p>quantity: <span id='demo" + i + "'></span></p>");
			out.println("<script>");
			out.println("var slider" + i + " = document.getElementById('" + items[i][0] + "');");
			out.println("var output" + i + " = document.getElementById('demo" + i + "');");
			out.println("output" + i + ".innerHTML = slider" + i + ".value;");
			out.println("slider" + i + ".oninput = function() { output" + i + ".innerHTML = this.value;");
			out.println("if(this.value >0 ){");
			out.println(" document.getElementsByName('" + items[i][0] + "')[0].checked = true;");
			out.println("}");
			out.println("else{");
			out.println(" document.getElementsByName('" + items[i][0] + "')[0].checked = false;");
			out.println("}");
			out.println("}");
			out.println("const checkbox" + i + " = document.getElementsByName('" + items[i][0] + "')[0];");
			out.println("checkbox" + i + ".addEventListener('change', (event) => {");
			out.println(" if (event.currentTarget.checked) {");
			out.println("slider" + i + ".value=1;");
			out.println("output" + i + ".innerHTML=1;");

			out.println("} else {");
			out.println("slider" + i + ".value=0;");
			out.println("output" + i + ".innerHTML=0;");

			out.println("}})");
			out.println("</script>");
		}
		%>

		<!-- <input type="checkbox" name="c1" value="brinjal">:Brinjal
		<input type="checkbox" name="c2" value="Potato">:Potato
		<input type="checkbox" name="c3" value="Tomato">:Tomato
	 -->
		<input type="submit" value="NextShop...">
	</form>


</body>
</html>