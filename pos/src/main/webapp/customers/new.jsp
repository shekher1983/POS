<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type='text/javascript'>

	function initCityList(){

	  var myArr = [];

		$.ajax({
			type: "GET",
			url: "${pageContext.request.contextPath}/data/cities.xml", // change to full path of file on server
			dataType: "xml",
			success: parseXml,
			complete: setupAC,
			failure: function(data) {
				alert("XML File could not be found");
				}
		});


		function parseXml(xml)
		{
			//find every query value
			$(xml).find("city").each(function()
			{
				myArr.push($(this).attr("label"));
			});
		}

		function setupAC() {
			$("input#city").autocomplete({
					source: myArr,
					minLength: 1,
					select: function(event, ui) {
						$("input#city").val(ui.item.value);

					}
			});
		}
	}


	$(document).ready(function() {
	initCityList();
	});
</script>
<form id="customer_form" accept-charset="utf-8" method="post" action="<s:url action="save"/>">
<s:token/>

<div id="required_fields_message">Fields marked with * are required</div>
<ul id="error_message_box"></ul>
<fieldset id="customer_basic_info">
<legend>Employee Basic Information</legend>
<div class="field_row clearfix">
	  <s:textfield  label="First Name" name="firstName"  required="true" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Last Name" name="lastName"   cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Nick Name" name="nickName"   cssClass="required" size="20" maxlength="20" />
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
	  <s:textfield  label="City" name="city" id="city" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="State" name="state" cssClass="required" size="20" maxlength="20" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Zip" name="zipCode"  cssClass="required" size="20" maxlength="10" />
</div>
<div class="field_row clearfix">
	  <s:textfield  label="Comments" name="note"   cssClass="required" size="40" maxlength="100" />
</div>
</fieldset>



<input type="submit" class="submit_button float_right" id="submit" value="Submit" name="submit">
</form>