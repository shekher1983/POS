<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="required_fields_message">Fields in red are required</div>
<ul id="error_message_box"></ul>
<form action="<s:url action="save"/>" method="post" accept-charset="utf-8" id="item_form"><fieldset id="item_basic_info">
<legend>Item Information</legend>
 <s:token/>

<div class="field_row clearfix">
<label for="name" class="required wide">Item Name:</label>	<div class='form_field'>
	<input type="text" name="name" value="" id="name"  />	</div>
</div>



<div class="field_row clearfix">
<label for="supplier" class="required wide">Category:</label>
<div class='form_field'>
	<select name="category">
         <option value="0" selected="selected">None</option>
    	<c:forEach var="item" items="${listCategory}">
         <option value="${item.id}" <c:if test="${product.category.id == item.id }">selected="selected"</c:if> >${item.name}</option>
         </c:forEach>
        </select>
        </div>
</div>


<div class="field_row clearfix">
<label for="description" class="wide">Description:</label>	<div class='form_field'>
	<textarea name="description" cols="17" rows="5" id="description" ></textarea>	</div>
</div>


<input type="submit" name="submit" value="Submit" id="submit" class="submit_button float_right"  /></fieldset>
</form>

//validation and submit handling
