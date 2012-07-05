<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table style="width: 500px;" id="contents">
	<tbody><tr>
		<td id="item_table">
			<table id="suspended_sales_table">
				<tbody><tr>
					<th>Suspended Sale ID</th>
					<th>Date</th>
					<th>Customer</th>
					<th>Comments</th>
					<th>Unsuspend</th>
					<th>Sales Receipt</th>
					<th>Delete</th>
				</tr>
        <jsp:useBean id="dateValue" class="java.util.Date" />

<c:forEach var="item" items="${orderEntityList}">
            <tr>
						<td>${item.id}</td>
                         <jsp:setProperty name="dateValue" property="time" value="${item.orderDate}" />

						<td><fmt:formatDate type="both"
            dateStyle="short" timeStyle="short"
            value="${dateValue}" /></td>
						<td>
							${item.customer.name}
							</td>
						<td>${item.note}</td>
						<td>
							<form accept-charset="utf-8" method="post" action="${pageContext.request.contextPath}/sales/unSuspend.ps">
                            <input type="hidden" value="${item.id}" name="orderId">
							<input type="submit" class="submit_button float_right" id="submit_unsuspend" value="Unsuspend" name="submit">
							</form>
						</td>
						<td>
							<form id="form_receipt_suspended_sale" method="get" accept-charset="utf-8" action="${pageContext.request.contextPath}/sales/receipt.ps">
							<input type="hidden" value="${item.id}" name="orderId">
							<input type="submit" class="submit_button float_right" id="submit_receipt" value="Receipt" name="submit">
							</form>
						</td>
						<td>
							<form id="form_delete_suspended_sale" accept-charset="utf-8" method="post" action="${pageContext.request.contextPath}/sales/delete.ps">
                            <input type="hidden" value="${item.id}" name="orderId">
							<input type="submit" class="submit_button float_right" id="submit_delete" value="Delete" name="submit">
							</form>
						</td>
					</tr>
            </c:forEach>



							</tbody></table>
		</td>
	</tr>
</tbody></table>