<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.inventory.services.CategoryServices"%>
<%@page import="com.inventory.model.Category"%>
<%@page import="org.apache.catalina.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="Update Category"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Update Category</h3>
			<br>

			<%

				int id = Integer.parseInt(request.getParameter("id"));
				Category category = CategoryServices.getCategory(id);
			%>
			<c:set var="item" value="<%=category%>">
			</c:set>

			<form action="CategoryController?page=updateCategory" method="post">

				<div class="form-group">
					<label for="id" class="col-md-3 control-label">Id</label>
					<div class="col-md-9">
						<input type="text" name="id" value="<%=category.getId()%>"
							readonly="readonly" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="fname" class="col-md-3 control-label">Category</label>
					<div class="col-md-9">
						<input type="text" name="itemCategory" value="<%=category.getItemCategory()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<a href="CategoryController?page=allCategory">
						<button type="button" class="btn btn-primary">Back</button>
					</a>
					<button type="submit" class="btn btn-primary">Update</button>

				</div>

			</form>

		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>