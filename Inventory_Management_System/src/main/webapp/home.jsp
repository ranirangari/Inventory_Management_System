<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="Login"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">

		<%
			Date dt = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh.mm.ss");
			String datetime = format.format(dt);
		%>
		
		<h4 style="margin-left: 15px">
			<%=datetime%></h4>
			
		<%
			String fname = (String) session.getAttribute("fname");
		%>
		<div class="col-md-6">
			<h3 style="margin-left: 15px">
				Welcome,
				<%=fname%></h3>
			<br>

		</div>
	</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<c:import url="include/footer.jsp"></c:import>