<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<script type="text/javascript">
$(document).ready(function()
{
    init_table_sorting();
    enable_select_all();
    enable_checkboxes();
    enable_row_selection();
    enable_search('<s:url action="suggest"/>','You have selected one or more rows, these will no longer be selected after your search. Are you sure you want to submit this search?');


});

function init_table_sorting()
{
	//Only init if there is more than one row
	if($('.tablesorter tbody tr').length > 1)
	{
		$("#sortable_table").tablesorter(
		{
			sortList: [[1,0]],
			headers:
			{
				0: { sorter: false}

			}

		});
	}
}

function post_item_form_submit(response)
{
	if(!response.success)
	{
		set_feedback(response.message,'error_message',true);
	}
	else
	{
		//This is an update, just update one row
		if(jQuery.inArray(response.item_id,get_visible_checkbox_ids()) != -1)
		{
			update_row(response.item_id,'${pageContext.request.contextPath}/items/get_row');
			set_feedback(response.message,'success_message',false);

		}
		else //refresh entire table
		{
			do_search(true,function()
			{
				//highlight new row

				highlight_row(response.item_id);

				set_feedback(response.message,'success_message',false);
			});
		}
	}
}

function post_bulk_form_submit(response)
{
	if(!response.success)
	{
		set_feedback(response.message,'error_message',true);
	}
	else
	{
		set_feedback(response.message,'success_message',false);
		setTimeout(function(){window.location.reload();}, 2500);
	}
}
</script>


<table id="title_bar">
	<tbody><tr>
		<td id="title_icon">
			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/items.png">
		</td>
		<td id="title">
			List of Items		</td>
		<td id="title_search">
			<form id="search_form" accept-charset="utf-8" method="post" action="<s:url action="search"/>">
			<input type="text" id="search" name="search" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
			</form>
		</td>
	</tr>

	<tr>
		<td colspan="3" id="commands">
			<div id="new_button">
				<a title="New Item" class="thickbox none new" href="<s:url action="new"/>">New Item</a>
				</div>
		</td>
		</tr>
</tbody></table>
<table id="contents">
	<tbody><tr>

		<td id="item_table">
			<div id="table_holder">
			<table id="sortable_table" class="tablesorter">
				<thead>
			<tr>
			<th class="leftmost"><input type="checkbox" id="select_all"></th>

			<th class="header headerSortDown">Item Name</th><th class="header">Category</th>
			<th class="header">Sale Price</th>
			<th class="header">Stock Quantity</th>
			<th class="header">Last Updated</th>
			<th class="rightmost">&nbsp;</th>
			</tr>
             <jsp:useBean id="dateValue" class="java.util.Date" />
             	</thead>
            <tbody>
			<c:forEach var="item" items="${products}">
             <jsp:setProperty name="dateValue" property="time" value="${item.lastUpdated}" />

             <tr style="cursor: pointer;">
             <td width="5%" class=""><input type="checkbox" value="${item.id}" id="item_${item.id}"></td>
             <td width="20%" class=""><a class="underline" href="${pageContext.request.contextPath}/reports/${item.id}">${item.name}</a></td>
             <td width="20%" class=""><a class="underline" href="<s:url action="list"/>?category=${item.category.id}">${item.category.name}</a></td>
             <td width="10%" class="">${item.salePrice}</td>
	          <td width="10%" class="">${item.stockQuantity}</td>

			<td><fmt:formatDate type="both"
            dateStyle="short" timeStyle="short"
            value="${dateValue}" /></td>
	         <td width="20%" class="rightmost"><a title="Update Item" class="thickbox" href="<s:url action="edit"/>?id=${item.id}"><img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a></a></td>
             </tr>
            </c:forEach>
            	</tbody>
		</table>
			</div>
			<div id="pagination">

				</div>
		</td>
	</tr>
</tbody></table>
<div id="feedback_bar"></div>
</div>