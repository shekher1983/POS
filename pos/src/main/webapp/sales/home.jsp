<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>

 <head>
	<meta charset="utf-8">
	<title>Order History</title>
 <script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.datepicker.js"></script>


	<script>
	$(function() {
		$( "#endDate" ).datepicker();
		$( "#startDate" ).datepicker();
	});
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

$(document).ready(function()
{
       init_table_sorting();
        tb_init('#sortable_table a.thickbox');
        initCityList();
       $("#filter_order_button").click(function()
                            {
                               var options = {
                                  target:     '#item_table',

                                  success:    function() {
                                      $('#spinner').hide();

              	                      init_table_sorting();
              	                       tb_init('#sortable_table a.thickbox');

                                  },
                                  beforeSubmit: function(){
              	                     $('#spinner').show();

                                  }
                              };
   	     $('#filter_order_form').ajaxSubmit(options);
          });




	$( "#name" ).autocomplete({
 		source: "<s:url action="suggest" namespace="/customers"/>",
		delay: 10,
 		autoFocus: false,
 		minLength: 0,
 		focus: function( event, ui ) {
				$( "#name" ).val(ui.item.label);
				$( "#customerId" ).val(ui.item.value);
				return false;
		},
 		select: function( event, ui )
 		{
			$( "#name" ).val(ui.item.label);

           return false;
 		}
	});
	});

	function init_table_sorting()
{

	//Only init if there is more than one row
	if($('.tablesorter tbody tr').length >1)
	{

		$("#sortable_table").tablesorter(
		{

			sortList: [[1,0]],
			headers:
			{
				0: { sorter: false},
				5: { sorter: false}
			}

		});
	}
}

	</script>
</head>
<form action="<s:url action="list"/>" method="post" accept-charset="utf-8" id="filter_order_form">

<div id="report_date_range_simple">
		<input type="radio" checked="checked" value="0" id="simple_radio" name="dateFilterType">
		<select id="report_date_range_simple" name="dateRange">
            <option value="0" <c:if test="${dateRange == 0 }">selected="selected"</c:if> >Today</option>
            <option value="1" <c:if test="${dateRange == 1 }">selected="selected"</c:if> >Yesterday</option>
            <option value="2" <c:if test="${dateRange == 2 }">selected="selected"</c:if> >Last 7 Days</option>
            <option value="3" <c:if test="${dateRange == 3 }">selected="selected"</c:if> >This Month</option>
            <option value="4" <c:if test="${dateRange == 4 }">selected="selected"</c:if> >Last Month</option>
            <option value="5" <c:if test="${dateRange == 5 }">selected="selected"</c:if> >This Year</option>
            <option value="6" <c:if test="${dateRange == 6 }">selected="selected"</c:if>>Last Year</option>
            <option value="7"<c:if test="${dateRange == 7 }">selected="selected"</c:if> >All Time</option>
        </select>
</div>
<div id="report_date_range_complex">
		<input type="radio" value="1" id="complex_radio" name="dateFilterType">
	    <input type="text" name="startDate" id="startDate">
		-
        <input type="text" name="endDate" id="endDate"/>
  </div>
<div class="field_row clearfix">
   <label for="customerId" class="required wide">Customer Name:</label>	<div class='form_field'>
   <input type="hidden" id="customerId" name="customerId" value="${customerId}"   />
	<input type="text" id="name" name="name" value="${customerId}"  />
	<input type="text" id="city" name="city" value="${city}" id="name"  />
	<input type="button" name="filter" id="filter_order_button" value="filter"/>
    <img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">

</div>
</div>
</form>
  <table id="title_bar">
                	<tbody><tr>
                		<td id="title_icon">
                			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/customers.png">
                		</td>
                		<td id="title">
                			List of Sales
                			</td>
                		<td id="title_search">
                			<form id="search_form" accept-charset="utf-8" method="post" action="<s:url action="search" namespace="/customers" />">
                			<input type="text" id="search" name="search" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
                				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
                			</form>
                		</td>
                	</tr>
                	<tr>
                    <td id="commands" colspan="2">
                    	<a title="New Employee" class=" none new" href="<s:url action="new"  />">New Order</a>
                    </td>

                	</tr>
                </tbody>
 </table>
<table style="width: 100%;" id="contents">
	<tr>
	<td id="item_table">
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
						<td><fmt:formatNumber value="${item.totalAmount}"  type="currency"/> </td>
						<td>${fn:length(item.itemList)}</td>
						 <td><fmt:formatNumber value="${item.totalAmount-item.dueAmount}"  type="currency"/></td>
						<td><fmt:formatNumber value="${item.dueAmount}"  type="currency"/> </td>
						<td> ${item.employee.name}</td>
                        <td>
                        <a title="Customer" class="thickbox" href="<s:url action="edit" namespace="/customers" />?id=${item.customer.id}">${item.customer.name},${item.customer.city}</a></td>
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

