 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>

   <script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.datepicker.js"></script>

<script>

  function init_table_sorting()
{
	;
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
	$(function() {
		$( "#endDate" ).datepicker();
		$( "#startDate" ).datepicker();
	});

	</script>
	<script type="text/javascript">

$(document).ready(function()
{
 init_table_sorting();

         $("#filter_payment_button").click(function()
              {
                 var options = {
                    target:     '#item_table',

                    success:    function() {
                          $('#spinner').hide();
                             tb_init('#sortable_table a.thickbox');

	                       init_table_sorting();

                    },
                    beforeSubmit: function(){
	                     $('#spinner').show();

                    }
                };

    	     $('#filter_payment_form').ajaxSubmit(options);
              });




     $( "#name" ).autocomplete({
		source: "<s:url action="suggest" namespace="/customers"/>",
		delay: 10,
		autoFocus: false,
		minLength: 0
	});

});



 </script>
</head>
<form action="<s:url action="list"/>" method="post" accept-charset="utf-8" id="filter_payment_form">
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
            <option value="7"<c:if test="${dateRange ==  7 }">selected="selected"</c:if> >All Time</option>
        </select>
</div>
<div id="report_date_range_complex">
		<input type="radio" value="1" id="complex_radio" name="dateFilterType">
	    <input type="text" name="startDate" id="startDate">-
        <input type="text" name="endDate" id="endDate"/>
</div>
<div class="field_row ">
    <label for="customerId" class="required wide">Customer Name:</label>
    <div class='form_field'>
	    <input type="text" id="name" name="customerId" value="${customerId}" id="name"  />
	    <input type="text" id="city" name="city" value="${city}" id="name"  />
	</div>
</div>

<div class="field_row clearfix">
    <label for="customerId" class="required wide"></label>
    <div class='form_field'>
	    <select id="report_date_range_simple" name="credited">
	      <option value="-1" <c:if test="${credited == -1 }">selected="selected"</c:if> >Credited or Debited</option>
            <option value="0" <c:if test="${credited == 0 }">selected="selected"</c:if> >Debited</option>
            <option value="1" <c:if test="${credited == 1 }">selected="selected"</c:if> >Credited</option>
        </select>

        <s:select required="true" label="Payment Type" name="paymentType" headerKey="-1" headerValue="--Payment Method--" listKey="id" listValue="name" list="paymentTypes" value="-1"/>

        <input id="filter_payment_button" type="button" name="filter" id="submit" value="filter"/>
        <img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">

	</div>
</div>


</form>


                <table id="title_bar">
                	<tbody><tr>
                		<td id="title_icon">
                			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/payment.jpg">
                		</td>
                		<td id="title">
                			List of Payments
                			</td>
                		<td id="title_search">
                			<form id="search_form" accept-charset="utf-8" method="post" action="${pageContext.request.contextPath}/customers/search.ps">
                			<input type="text" id="search" name="term" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
                				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
                			</form>
                		</td>
                	</tr>
                	<tr>
                    <td id="commands" colspan="2">
                             <a title="New Employee" class="thickbox none new" href="<s:url action="new"/>">New Payment</a>
                    	</td>

                	</tr>
                </tbody>
               </table>
               <table id="contents">
               <tr>

                <td id="item_table">
                <div id="table_holder">
                <table id="sortable_table" class="tablesorter">
                <thead>
                			<tr>
                			<th class="leftmost">
                			    <input type="checkbox" id="select_all">
                			</th>
                            <th class="header headerSortDown">ID#</th>
                			<th class="header headerSortDown">Customer</th>
                            <th class="header headerSortDown">Received By</th>
                			<th class="header">Amount</th>
                			<th class="header">Date</th>
                			<th class="header">Type</th>
                			<th class="rightmost">Action</th>
                			</tr></thead>
                            <jsp:useBean id="dateValue" class="java.util.Date" />

                </thead>
                <tbody>
                			<c:forEach var="item" items="${paymentEntities}">
                             <tr style="cursor: pointer;">
                              <td width="5%" class=""><input type="checkbox" value="${item.id}" id="person_1773"></td>

                              <td width="20%" class=""><c:if test="${item.credited}">Credited</c:if> <a class="underline" href="${pageContext.request.contextPath}/reports/list.ps?customerId=${item.id}">${item.id}</a></td>
                               <td width="20%" class=""><a class="underline" href="${pageContext.request.contextPath}/reports/list.ps?customerId=${item.id}">${item.customer.name}<br/>(${item.customer.city})</a></td>
                                <td width="20%" class=""><a class="underline" href="${pageContext.request.contextPath}/reports/list.ps?customerId=${item.id}">${item.employee.userName}</a></td>
                               <td width="20%" class=""><a class="underline" href="${pageContext.request.contextPath}/reports/list.ps?customerId=${item.id}">
                                <fmt:formatNumber value="${item.amount}"  type="currency"/> </a></td>
                                 <jsp:setProperty name="dateValue" property="time" value="${item.paymentDate}" />

                              <td width="20%" class=""><fmt:formatDate pattern="dd/MM/yyyy hh:mm aaa"  value="${dateValue}" /></td>
                              <td width="20%" class="">${item.type.name}</td>
                             <td width="5%" class="rightmost"><a title="Update Payment" class="thickbox" href="<s:url action="edit"/>?id=${item.id}"><img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a></a></td>

                             </tr>
                            </c:forEach>

                </tbody>
            </table>

           <c:if test="${not empty paymentEntities }">
			<table>
                 <tr>
                 <td colspan="2">Total Payment Amount</td><td><fmt:formatNumber value="${totalPaymentAmount}"  type="currency"/></td>
                 </tr>
			</table>
			</c:if>
        </div>
        <div id="pagination">
        </div>
        </td>
        </tr>
      </tbody>
     </table>
     <div id="feedback_bar"></div>
