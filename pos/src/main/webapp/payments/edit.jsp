<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="required_fields_message">Fields in red are required</div>
<ul id="error_message_box"></ul>


<form action="<s:url action="update"/>" method="post" accept-charset="utf-8" id="item_form">
<fieldset id="item_basic_info">
<legend>Payment Information</legend>

 <jsp:useBean id="dateValue" class="java.util.Date" />

<div class="field_row clearfix">
   <s:radio label="Credit/Debit?" required="true" name="credited" list="#{false:'Debited', true:'Credited'}"/>
</div>

<div class="field_row clearfix">
	  <s:textfield  label="Customer Name" name="customerId"   id="name" cssClass="required" size="20" maxlength="20" />
</div>

<div class="field_row clearfix">
<s:select required="true" label="Payment Type" name="paymentType" headerKey="-1" headerValue="--Payment Method--" listKey="id" listValue="name" list="paymentTypes" />
</div>

<div class="field_row clearfix">
	  <s:textfield  label="Payment Amount" name="paymentAmount"   id="paymentAmount"   cssClass="required" size="20" maxlength="20" />
</div>

  <jsp:setProperty name="dateValue" property="time" value="${paymentEntity.paymentDate}" />

<div class="field_row clearfix">
	  <s:textfield  label="Payment Date" name="paymentDate"    id="paymentDate"   cssClass="required" size="20" maxlength="20" />
</div>

<div class="field_row clearfix">
	  <s:textarea  label="Comments" name="comment"   id="comment"    />
</div>


<input type="submit" name="submit" value="Submit" id="submit" class="submit_button float_right"  /></fieldset>
</form><script type='text/javascript'>

//validation and submit handling
$(document).ready(function()
{
	$( "#name" ).autocomplete({
		source: "${pageContext.request.contextPath}/customers/search.ps",
		delay: 10,
		autoFocus: false,
		minLength: 0
	});


});
</script>