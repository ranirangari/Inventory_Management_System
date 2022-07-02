<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.inventory.services.ItemServices"%>
<%@page import="com.inventory.model.ItemBean"%>
<%@page import="org.apache.catalina.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="Update Item"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">Update Item</h3>
			<br>

			<%

				int id = Integer.parseInt(request.getParameter("id"));
				ItemBean item = ItemServices.getItem(id);
			%>
			<c:set var="item" value="<%=item%>">
			</c:set>

			<form action="ItemController?page=updateItem" method="post">

				<div class="form-group">
					<label for="id" class="col-md-3 control-label">Id</label>
					<div class="col-md-9">
						<input type="text" name="id" value="<%=item.getId()%>"
							readonly="readonly" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemCode" class="col-md-3 control-label">Code</label>
					<div class="col-md-9">
						<input type="text" name="itemCode" value="<%=item.getItemCode()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemName" class="col-md-3 control-label">Item
						Name</label>
					<div class="col-md-9">
						<input type="text" name="itemName" value="<%=item.getItemName()%>"
							class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemBrand" class="col-md-3 control-label">Brand</label>
					<div class="col-md-9">
						<input type="text" name="itemBrand"
							value="<%=item.getItemBrand()%>" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemCategory" class="col-md-3 control-label">Category</label>
					<div class="col-md-9">
						<input type="text" name="itemCategory"
							value="<%=item.getItemCategory()%>" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemDescription" class="col-md-3 control-label">Description</label>
					<div class="col-md-9">
						<input type="text" name="itemDescription"
							value="<%=item.getItemDescription()%>" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemQuantity" class="col-md-3 control-label">Quantity</label>
					<div class="col-md-9">
						<input type="text" name="itemQuantity"
							value="<%=item.getItemQuantity()%>" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				<div class="form-group">
					<label for="itemPrice" class="col-md-3 control-label">Price</label>
					<div class="col-md-9">
						<input type="text" name="itemPrice"
							value="<%=item.getItemPrice()%>" class="form-control"></input>
					</div>
				</div>
				&nbsp;

				

				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<a href="ItemController?page=allItem">
						<button type="button" class="btn btn-primary">Back</button>
					</a>
					<button type="submit" class="btn btn-primary">Update</button>

				</div>

			</form>

		</div>
	</div>
</div>

<c:import url="include/footer.jsp"></c:import>