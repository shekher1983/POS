<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form id="employee_form" accept-charset="utf-8" method="post" action="<s:url action="update"/>">
<s:token/>
<input type="hidden"  name="id" value="${id}" />

<div id="required_fields_message">Fields marked with * are required</div>
<ul id="error_message_box"></ul>
<fieldset id="employee_basic_info">
<legend>Employee Basic Information</legend>
<div class="field_row clearfix">
	  <s:textfield  label="First Name" name="firstName"  required="true" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Last Name" name="lastName"  cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="E-Mail" name="email"   cssClass="required" size="20" maxlength="40" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Phone Number" name="primaryCell"  cssClass="required" size="20" maxlength="10" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Address" name="address"  cssClass="required" size="40" maxlength="100" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="City" name="city"  cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="State" name="state"   cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Zip" name="zipCode"   cssClass="required" size="20" maxlength="10" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Comments" name="note"    cssClass="required" size="40" maxlength="100" />
</div>
</fieldset>
<fieldset id="employee_login_info">
<legend>Employee Login Info</legend>
  <div class="field_row clearfix">
	  <s:textfield  label="User Name" name="userName"    cssClass="required" size="20" maxlength="100" />
</div>
<div class="field_row clearfix">
  <s:password label="Password" name="password" required="true" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:password label="Confirm Password" name="confirmpassword" required="true" cssClass="required" size="20" maxlength="20" />
</div>
</fieldset>

<fieldset id="employee_permission_info">
<legend>Employee Permissions and Access</legend>
<p>Check the boxes below to grant access to modules</p>



<ul id="permission_list">

 <c:forEach var="item" items="${allRoles}">
<li>
<input type="checkbox" value="${item.id}" name="roles"<c:if test="${  fn:contains( roles, item.id ) }">checked="true"</c:if> >
<span class="medium">${item.name}:</span>
<span class="small">${item.description}</span>
</li>
  </c:forEach>
</ul>
</fieldset>
<input type="submit" class="submit_button float_right" id="submit" value="Submit" name="submit">
</form>