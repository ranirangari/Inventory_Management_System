<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.inventory.model.ItemBean"%>

<%@page import="org.apache.catalina.User"%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="include/header.jsp">
	<c:param name="title" value="All Category"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
			<h3 style="margin-left: 15px">All Category</h3>
			<br>

			<%

				List<ItemBean> allCategory = (List)request.getAttribute("allCategory");
			%>
			<table
				class="table display data-table text-nowrap dataTable no-footer"
				id="DataTables_Table_0" role="grid">

				<thead>
					<tr role="row">
						<th>Categories Name</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="<%=allCategory%>" var="category">
						<tr>
							<td>${category.itemCategory}</td>

							<td> <a href="updatecategory.jsp?id=${category.id}">Update |</a> 
								
							<a href="CategoryController?page=deleteCategory&id=${category.id}"
								onclick="if (confirm('Do you want to delete this category?'))
								form.action='CategoryController?page=remove&id=${category.id }'; 
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