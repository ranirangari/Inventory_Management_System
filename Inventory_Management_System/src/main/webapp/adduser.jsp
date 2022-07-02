<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="Add Users"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Add User</h3>
			<br>

			<form action="MainController?page=addUser" method="post">

				<div class="form-group">
					<label for="email" class="col-md-3 control-label">First
						Name</label>
					<div class="col-md-9">
						<input type="text" name="fname" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Middle
						Name</label>
					<div class="col-md-9">
						<input type="text" name="mname" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Last
						Name</label>
					<div class="col-md-9">
						<input type="text" name="lname" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Email</label>
					<div class="col-md-9">
						<input type="text" name="email" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Mobile</label>
					<div class="col-md-9">
						<input type="text" name="mobile" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Address</label>
					<div class="col-md-9">
						<input type="text" name="address" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="password" class="col-md-3 control-label">Password</label>
					<div class="col-md-9">
						<input type="password" name="password" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<button type="reset" class="btn btn-primary">Clear</button>
					<button type="submit" class="btn btn-primary">Add</button>
					
				</div>

			</form>

		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>