<%@page import="com.itextpdf.text.log.SysoCounter"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Collections"%>
<%@page import="order.orderBuisness"%>
<%@page import="java.util.Arrays"%>
<%@page import="bill.PDF"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome...Now Make the payment Mr/Ms..:<%=session.getAttribute("uname")%></h3>
	<%
	try{
	Enumeration<String> en = session.getAttributeNames();

	int size = 19, i = 0,k=0;
	String items[] = new String[size];
	String itemName[] = new String[size];
	String temp[]=new String[size];
	int quan[] = new int[size];
	while (en.hasMoreElements()) {
		String name = en.nextElement();
		Object value = session.getAttribute(name);
		if (!name.equals("formid") && !name.equals("shopid") && !name.equals("uname")) {
			if(name.endsWith("quan")){
				//System.out.println(name+" "+name.replace("quan", ""));
				temp[k++]=name;
			}else{
				itemName[i] = (String) value;
				items[i++] = name;
				out.println("<h1>" + name + " : " + value + " <h2 id='"+name+"'> quantity : "+ quan[i-1] + "</h2> </h1>");
			}
			//quan[i] = 1;
			System.out.println(i+" "+quan[i-1>0?0:(i-1)]);
		}
	}
	System.out.println("quantity");
	for(int j=0;j<k;j++){
		System.out.print(j+" \t");
		String value = (String)session.getAttribute(temp[j]);
		int in=findIndex(Arrays.copyOfRange(items, 0, i),temp[j].replace("quan", ""));
		if(in!=-1){
			quan[in]=Integer.parseInt(value);
			System.out.println(in+" "+quan[in]);
			out.println("<script>");
			out.println("document.getElementById("+temp[j].replace("quan", "")+").innerHTML='quantity : "+quan[in]+"';");
			out.println("");
			out.println("</script>");
		}
	}
	//System.out.println("names : ");
	PDF.setItems(Arrays.copyOfRange(itemName, 0, i));
	//String itempart[]=Arrays.copyOfRange(items,0,i);
	new orderBuisness().order(Arrays.copyOfRange(items, 0, i), Arrays.copyOfRange(quan, 0, i),
			(String) session.getAttribute("uname"));
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	<%!
	int findIndex(String arr[],String word) throws Exception{
		System.out.print(word +"\t"+arr.length+"\t");
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(word)){
				System.out.println(i);
				return i;
			}
		}
		return -1;
	} %>
	<form action="pdf.do">
		<input type="hidden" name="formid" value="pdf"> <input
			type="submit" value="PAY">
	</form>

</body>
</html>