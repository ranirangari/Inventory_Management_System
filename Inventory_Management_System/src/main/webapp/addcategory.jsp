<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.catalina.User"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="include/header.jsp">
	<c:param name="title" value="Add Category"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Add Category</h3>
			<br>

			<form action="CategoryController?page=addCategory" method="post">

				<div class="form-group">
					<label for="itemCategory" class="col-md-3 control-label">Category</label>
					<div class="col-md-9">
						<input type="text" name="itemCategory" class="form-control"></input>
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