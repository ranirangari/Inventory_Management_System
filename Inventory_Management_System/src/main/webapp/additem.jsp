<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.inventory.services.ItemServices"%>
<%@page import="com.inventory.services.CategoryServices"%>
<%@page import=" java.sql.ResultSet"%>

<%@page import="com.inventory.model.ItemBean"%>
<%@page import="java.util.List"%>


<c:import url="include/header.jsp">
	<c:param name="title" value="Add Items"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Add Item</h3>
			<br>

			<form action="ItemController?page=addItem" method="post">

				<div class="form-group">
					<label for="itemCode" class="col-md-3 control-label">Code</label>
					<div class="col-md-9">
						<input type="text" name="itemCode" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemName" class="col-md-3 control-label">Item
						Name</label>
					<div class="col-md-9">
						<input type="text" name="itemName" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemBrand" class="col-md-3 control-label">Brand</label>
					<div class="col-md-9">
						<input type="text" name="itemBrand" class="form-control"></input>
					</div>
				</div>
				&nbsp;


				<div class="form-group">
					<label for="itemCategory" class="col-md-3 control-label">Category</label>
					<div class="col-md-9">
						<select class="form-control" name="itemCategory">
							<c:forEach items="${allCategory}" var="categories">
								<option value="${categories.itemCategory}">${categories.itemCategory}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				&nbsp;


				<div class="form-group">
					<label for="itemDescription" class="col-md-3 control-label">Description</label>
					<div class="col-md-9">
						<input type="text" name="itemDescription" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemQuantity" class="col-md-3 control-label">Quantity</label>
					<div class="col-md-9">
						<input type="text" name="itemQuantity" class="form-control"></input>
					</div>
				</div>
				&nbsp;



				<div class="form-group">
					<label for="itemPrice" class="col-md-3 control-label">MRP</label>
					<div class="col-md-9">
						<input type="text" name="itemPrice" class="form-control"></input>
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