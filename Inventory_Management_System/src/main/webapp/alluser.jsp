<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.inventory.model.UserBean"%>
<%@page import="org.apache.catalina.User"%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="All Users"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">All Users</h3>
			<br>

			<%
				List<UserBean> allUser = (List)request.getAttribute("allUser");
			%>
			<table
				class="table display data-table text-nowrap dataTable no-footer"
				id="DataTables_Table_0" role="grid">

				<thead>
					<tr role="row">
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="<%=allUser%>" var="user">
						<tr>
							<td>${user.fname} ${user.mname} ${user.lname}</td>
							<td>${user.email}</td>
							<td>${user.mobile}</td>
							<td>${user.address}</td>

							<td> <a href="updateuser.jsp?id=${user.id}">Update |</a> 
								
							<a href="MainController?page=deleteUser&id=${user.id}"
								onclick="if (confirm('Do you want to delete this user?'))
								form.action='MainController?page=remove&id=${user.id }'; 
								else return false;">Delete</a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>