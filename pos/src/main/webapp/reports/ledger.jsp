<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="s" uri="/struts-tags" %>


<table style="width: 100%;" id="contents">
<tr><td>${customer.name}</td></tr>
<tr><td>${customer.address}</td></tr>
<tr><td>${customer.city}</td></tr>
<tr><td>${customer.primaryCell}</td></tr>
</table>

<table style="width: 100%;" id="contents">
	<tbody><tr>
		<td id="item_table">
			<table id="suspended_sales_table">
				<tbody><tr>
					<th>ID#</th>
					<th>Date</th>
					<th>Comments</th>
					<th>Total Amount</th>
					<th>Payment</th>
					<th>Due Amount</th>
					<th>Employee</th>
					<th>Sales Receipt</th>

				</tr>
        <jsp:useBean id="dateValue" class="java.util.Date" />

<c:forEach var="item" items="${orderEntities}">
            <tr>
						<td>${item.orderType.name}- ${item.id}</td>
						   <jsp:setProperty name="dateValue" property="time" value="${item.orderDate}" />

						<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm aaa"        value="${dateValue}" /></td>

						<td>${item.note}</td>
						<td><fmt:formatNumber value="${item.totalAmount}"  type="currency"/> </td>
                        <td><fmt:formatNumber value="${item.totalAmount-item.dueAmount}"  type="currency"/> </td>
						<td><fmt:formatNumber value="${item.dueAmount}"  type="currency"/> </td>
						<td> ${item.employee.userName}</td>

						<td>
							<form id="form_receipt_suspended_sale" method="get" accept-charset="utf-8" action="${pageContext.request.contextPath}/receipts/orderreceipt.ps">
							<input type="hidden" value="${item.id}" name="id">
							<input type="submit" class="submit_button float_right" id="submit_receipt" value="Receipt" name="submit">
							</form>
						</td>

					</tr>
            </c:forEach>
            <c:forEach var="item" items="${paymentEntities}">
            <tr>
						<td>Payment-${item.id}</td>

                         <jsp:setProperty name="dateValue" property="time" value="${item.paymentDate}" />

						<td><fmt:formatDate type="both"    dateStyle="short" timeStyle="short"     value="${dateValue}" /></td>

						<td>${item.note}</td>
						<td>INR 0</td>
                        <td><fmt:formatNumber value="${item.amount}"  type="currency"/></td>
						<td>INR 0</td>
						<td> ${item.employee.userName}</td>

						<td>
							<form id="form_receipt_suspended_sale" method="get" accept-charset="utf-8" action="${pageContext.request.contextPath}/receipts/paymentreceipt.ps">
							<input type="hidden" value="${item.id}" name="id">
							<input type="submit" class="submit_button float_right" id="submit_receipt" value="Receipt" name="submit">
							</form>
						</td>

					</tr>
            </c:forEach>
             <tr><td colspan="3">Total Order</td><td>${totalOrderAmount}</td> </tr>

                           <tr><td colspan="5">Total Due Amount</td><td>${totalDueAmount}</td> </tr>
                             <tr><td colspan="4">Amount Paid</td><td>${totalPaymentAmount}</td> </tr>
                            <tr><td colspan="2">Final Amount Due</td><td>${totalDueAmount-totalPaymentAmount}</td> </tr>


							</tbody></table>
		</td>
	</tr>
</tbody></table>