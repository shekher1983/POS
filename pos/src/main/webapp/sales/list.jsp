<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<table id="sortable_table" class="tablesorter">
		<thead>
			<tr>
					<th>ID#</th>
					<th>Date</th>
					<th>Comments</th>
					<th>Total Amount</th>
					<th>Items Purchased</h>
					<th>Payment</th>
					<th>Due Amount</th>
					<th>Sold By</th>
					<th>Sold To</th>
					<th>Receipt</th>
			</tr>
		</thead>
		<tbody>
        <jsp:useBean id="dateValue" class="java.util.Date" />
        <c:forEach var="item" items="${orderEntityList}">
            <tr>
						<td>${item.id}</td>
                         <jsp:setProperty name="dateValue" property="time" value="${item.orderDate}" />
                       	<td><fmt:formatDate pattern="dd/MM/yyyy hh:mm aaa"  value="${dateValue}" /></td>
						<td>${item.note}</td>
						<td><fmt:formatNumber value="${item.totalAmount}"  type="currency"/></td>
						<td>${fn:length(item.itemList)}</td>
						 <td><fmt:formatNumber value="${item.totalAmount-item.dueAmount}"  type="currency"/> </td>
						<td><fmt:formatNumber value="${item.dueAmount}"  type="currency"/></td>
                         <td>  <a title="Customer" class="thickbox" href="<s:url action="edit" namespace="/customers" />?id=${item.customer.id}">${item.customer.name},${item.customer.city}</a></td>
                       		<td> ${item.customer.name},${item.customer.city}</td>
						<td>
							<form id="form_receipt_suspended_sale" method="get" accept-charset="utf-8" action="${pageContext.request.contextPath}/receipts/orderreceipt.ps">
							<input type="hidden" value="${item.id}" name="id">
							<input type="submit" class="submit_button float_right" id="submit_receipt" value="Receipt" name="submit">
							</form>
						</td>

			</tr>
            </c:forEach>
			</tbody>
	</table>
			<c:if test="${not empty orderEntityList }">
			<table>
                    <tr>
                         <td colspan="2">Total Order</td><td>${totalOrderAmount}</td>
                    </tr>
                    <tr>
                         <td colspan="2">Amount Paid</td><td>${ordersTotalPaymentAmount}</td>
                    </tr>
                    <tr>
                        <td colspan="2">Total Due Amount</td><td>${totalDueAmount}</td>
                    </tr>
			</table>
			</c:if>
		</td>
	</tr>
</tbody></table>

