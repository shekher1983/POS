<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="required_fields_message">Fields in red are required</div>
<ul id="error_message_box"></ul>
<form action="<s:url action="update"/>" method="post" accept-charset="utf-8" id="item_form"><fieldset id="item_basic_info">
<legend>Item Information</legend>
<jsp:useBean id="dateValue" class="java.util.Date" />
<jsp:setProperty name="dateValue" property="time" value="${product.lastUpdated}" />
 <input type="hidden" name="id" value="${product.id}"/>
  <s:token/>
<div class="field_row clearfix">
	  <s:textfield  label="Item Name" name="name"  required="true" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Sale price" name="salePrice"   cssClass="required" size="20" maxlength="20" />(Updated :${dateValue})
</div>

<div class="field_row ">
<label for="supplier" class="required wide">Category:</label>
<div class='form_field'>
	   <select name="category">
         <option value="0" selected="selected">None</option>
    	<c:forEach var="item" items="${listCategory}">
         <option value="${item.id}" <c:if test="${category == item.id }">selected="selected"</c:if> >${item.name}</option>
         </c:forEach>
        </select>
	</div>
</div>




<div class="field_row ">
	  <s:textarea  label="Description" name="description" rows="5" cols="40"/>
</div>

  <div class="field_row clearfix">

<input type="submit" name="submit" value="Submit" id="submit" class="submit_button float_right"  />
</div>
</fieldset>
</form>
