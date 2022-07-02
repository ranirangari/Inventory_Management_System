<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.inventory.model.ItemBean"%>
<%@page import="org.apache.catalina.User"%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="All Items"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">All Items</h3>
			<br>

			<%
				List<ItemBean> allItem = (List)request.getAttribute("allItem");
			%>
			<table
				class="table display data-table text-nowrap dataTable no-footer"
				id="DataTables_Table_0" role="grid">

				<thead>
					<tr role="row">
						<th>Code</th>
						<th>Item Name</th>
						<th>Brand</th>
						<th>Category</th>
						<th>Description</th>
						<th>Quantity</th>
						<th>MRP</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="<%=allItem%>" var="item">
						<tr>
							<td>${item.itemCode}</td>
							<td>${item.itemName}</td>
							<td>${item.itemBrand}</td>
							<td>${item.itemCategory}</td>
							<td>${item.itemDescription}</td>
							<td>${item.itemQuantity}</td>
							<td>${item.itemPrice}</td>

							<td><a href="updateitem.jsp?id=${item.id}">Update |</a> <a
								href="ItemController?page=deleteItem&id=${item.id}"
								onclick="if (confirm('Do you want to delete this item?'))
								form.action='ItemController?page=remove&id=${item.id }'; 
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