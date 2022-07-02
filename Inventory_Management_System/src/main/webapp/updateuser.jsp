<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.inventory.services.UserServices"%>
<%@page import="com.inventory.model.UserBean"%>
<%@page import="org.apache.catalina.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="Update User"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Update User</h3>
			<br>

			<%

				int id = Integer.parseInt(request.getParameter("id"));
				UserBean user =UserServices.getUser(id);

			%>
			<c:set
				var="user" value="<%=user%>">
			</c:set>

			<form action="MainController?page=updateUser" method="post">

				<div class="form-group">
					<label for="id" class="col-md-3 control-label">Id</label>
					<div class="col-md-9">
						<input type="text" name="id" value="<%=user.getId()%>"
							readonly="readonly" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="fname" class="col-md-3 control-label">First
						Name</label>
					<div class="col-md-9">
						<input type="text" name="fname" value="<%=user.getFname()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="mname" class="col-md-3 control-label">Middle
						Name</label>
					<div class="col-md-9">
						<input type="text" name="mname" value="<%=user.getMname()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="lname" class="col-md-3 control-label">Last Name</label>
					<div class="col-md-9">
						<input type="text" name="lname" value="<%=user.getLname()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="email" class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<input type="text" name="email" value="<%=user.getEmail()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="mobile" class="col-md-3 control-label">Mobile</label>
					<div class="col-md-9">
						<input type="text" name="mobile" value="<%=user.getMobile()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="address" class="col-md-3 control-label">Address</label>
					<div class="col-md-9">
						<input type="text" name="address" value="<%=user.getAddress()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password</label>
					<div class="col-md-9">
						<input type="password" name="password" value="<%=user.getPassword()%>" 
						class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<a href="MainController?page=allUser">
						<button type="button" class="btn btn-primary">Back</button>
					</a>
					<button type="submit" class="btn btn-primary">Update</button>

				</div>

			</form>

		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>