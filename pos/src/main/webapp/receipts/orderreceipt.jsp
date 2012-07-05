<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="dateValue" class="java.util.Date" />
<jsp:setProperty name="dateValue" property="time" value="${orderEntity.orderDate}" />


<div id="receipt_wrapper">
	<div id="receipt_header">
		<div id="company_name">${config.storeName}</div>
				<div id="company_address">${config.storeAddress}</div>
		<div id="company_phone">${config.storePhone}</div>
		<div id="sale_receipt">Sales Receipt</div>
		<div id="sale_time"><fmt:formatDate value="${dateValue}" pattern="MM/dd/yyyy HH:mm" /></div>
	</div>
	<div id="receipt_general_info">
				<div id="sale_id">Sale ID: ${orderEntity.id}</div>
		<div id="employee">Employee:${orderEntity.employee.userName}</div>
	</div>

<table id="receipt_items">

	<tr>
	<th style="width:33%;text-align:center;">Item #</th>
	<th style="width:20%;text-align:center;">Unit Price</th>
	<th style="width:15%;text-align:center;">Qty.</th>
	<th style="width:16%;text-align:center;">Discount</th>
	<th style="width:16%;text-align:center;">Line Total</th>
	</tr>

	 <c:forEach var="item" items="${orderEntity.itemList}">
        <tr>
            <td style="text-align:center;">
            <span class="long_name">${item.product.name}</span>
            </td>
            <td style="text-align:center;"><fmt:formatNumber value="${item.salePrice}"  type="currency"/> </td>
            <td style="text-align:center;">${item.quantity}</td>
            <td style="text-align:center;"><fmt:formatNumber value="${item.discount}"  type="currency"/> </td>
            <td style="text-align:right;"><fmt:formatNumber value="${item.totalAmount}"  type="currency"/> </td>
        </tr>
	</c:forEach>

	<tr>
        <td style="text-align:right;borderEntity-top:2px solid #000000;" colspan="4">Sub Total</td>
        <td style="text-align:right;border-top:2px solid #000000;" colspan="2">
        <fmt:formatNumber value="${orderEntity.subTotalAmount}"  type="currency"/>}</td>
	</tr>

		<tr>
			<td style="text-align:right;" colspan="4">Shipping & Handling:</td>
			<td style="text-align:right;" colspan="2"><fmt:formatNumber value="${orderEntity.shippingAmount}"  type="currency"/></td>
		</tr>
			<tr>
			<td style="text-align:right;" colspan="4">Discount:</td>
			<td style="text-align:right;" colspan="2"><fmt:formatNumber value="${orderEntity.discount}"  type="currency"/> </td>
		</tr>

	<tr>
	<td style="text-align:right;" colspan="4">Total</td>
	<td style="text-align:right" colspan="2"><fmt:formatNumber value="${orderEntity.totalAmount}"  type="currency"/></td>
	</tr>

 <c:forEach var="item" items="${orderEntity.paymentList}">
     <tr>
         <td style="text-align:right;" colspan="2">Payment Type</td>
         <td style="text-align:right;" colspan="2">${item.type.name} </td>
         <td style="text-align:right" colspan="2">INR ${item.amount}  </td>
     </tr>
 </c:forEach>

    <tr><td colspan="6">&nbsp;</td></tr>
    <tr><td colspan="6">&nbsp;</td></tr>
    <tr>
		<td style="text-align:right;" colspan="4">Amount Due</td>
		<td style="text-align:right" colspan="2">INR ${orderEntity.dueAmount}</td>
	</tr>
</table>

	<div id="sale_return_policy">Note: (${orderEntity.note})
	Test	</div>
	<div id="barcode">
	<div id="signature">
	Thank you for your business!
	</div>
</div>