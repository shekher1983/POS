<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="dateValue" class="java.util.Date" />
<jsp:setProperty name="dateValue" property="time" value="${paymentEntity.paymentDate}" />


<div id="receipt_wrapper">
	<div id="receipt_header">
		<div id="company_name">${config.storeName}</div>
				<div id="company_address">${config.storeAddress}</div>
		<div id="company_phone">${config.storePhone}</div>
		<div id="sale_receipt">Payment Receipt</div>
		<div id="sale_time"><fmt:formatDate value="${dateValue}" pattern="MM/dd/yyyy HH:mm" /></div>
	</div>
	<div id="receipt_general_info">
				<div id="sale_id">Receipt # ${paymentEntity.id}</div>
		<div id="employee">By ${paymentEntity.employee.userName}</div>
	</div>

<table id="receipt_items">

	<tr>
	<td style="text-align:left;" >Received From:</td></tr>
	<tr><td style="text-align:left;">${paymentEntity.customer.name}</td></tr>
    <tr><td>${paymentEntity.customer.address}</td></tr>
    <tr><td>${paymentEntity.customer.city}</td></tr>
    <tr><td>${paymentEntity.customer.primaryCell}</td></tr>

<tr>
<td style="text-align:right" >The Amount of: <fmt:formatNumber value="${paymentEntity.amount}"  type="currency"/>  ${paymentEntity.type.label}</td>
	</tr>

</table>

	<div id="sale_return_policy">Note: (${paymentEntity.note})
	Test	</div>
	<div id="barcode">
	<div id="signature">
	Thank you for your business!
	</div>
</div>