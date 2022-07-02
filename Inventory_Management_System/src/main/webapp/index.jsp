<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/loginheader.jsp">
	<c:param name="title" value="Login"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<br>

			<%
				String errormsg = (String) request.getAttribute("msg");
				if (errormsg != null) {
			%>
			<h6 style="color: red; margin-left: 15px">
				<%=errormsg%></h6>
			<br>
			<%
				}
			%>

			<form action="MainController?page=login" method="post">

				<div class="form-group">
					<label for="username" class="col-md-3 control-label">Username</label>
					<div class="col-md-9">
						<input type="text" name="username" class="form-control"></input>
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

				<div style="margin-left: 155px">
					<a href="register.jsp">New User/Register Here</a><br>
				</div>
				&nbsp;

				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<button type="submit" class="btn btn-primary">Log In</button>
				</div>

			</form>

		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>