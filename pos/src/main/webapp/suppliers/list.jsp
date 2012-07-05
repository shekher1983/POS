<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
$(document).ready(function()
{
    init_table_sorting();
    enable_select_all();
    enable_checkboxes();
    enable_row_selection();
    enable_search('<s:url action="suggest"/>','You have selected one or more rows, these will no longer be selected after your search. Are you sure you want to submit this search?');
    enable_email('${pageContext.request.contextPath}/suppliers/mailto');
    enable_delete('Are you sure you want to delete the selected suppliers?','You have not selected any suppliers to delete');
	enable_cleanup('Are you sure you want to clean ALL deleted suppliers? (This will remove account numbers from deleted suppliers so they can be reused)');
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
function post_person_form_submit(response)
{
	if(!response.success)
	{
		set_feedback(response.message,'error_message',true);
	}
	else
	{
		//This is an update, just update one row
		if(jQuery.inArray(response.person_id,get_visible_checkbox_ids()) != -1)
		{
			update_row(response.person_id,'${pageContext.request.contextPath}/suppliers/get_row');
			set_feedback(response.message,'success_message',false);

		}
		else //refresh entire table
		{
			do_search(true,function()
			{
				//highlight new row
				highlight_row(response.person_id);
				set_feedback(response.message,'success_message',false);
			});
		}
	}
}
</script>

<table id="title_bar">
	<tbody><tr>
		<td id="title_icon">
			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/suppliers.png">
		</td>
		<td id="title">
			List of Suppliers		</td>
		<td id="title_search">
			<form id="search_form" accept-charset="utf-8" method="post" action="<s:url action="search"/>">
			<input type="text" id="search" name="search" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
			</form>
		</td>
		<td id="commands">
			<div id="new_button">
				<a title="New Supplier" class="thickbox none new" href="<s:url action="new"/>">New Supplier</a>
		</td>
	</tr>
</tbody></table>
<table id="contents">
	<tbody><tr>

		<td id="item_table">
			<div id="table_holder">
			<table id="sortable_table" class="tablesorter">
			<tr><th class="leftmost"><input type="checkbox" id="select_all"></th>
			<th class="header">Company Name</th>
			<th class="header">Name</th>
            <th class="header headerSortDown">City</th>
			<th class="header">E-Mail</th>
			<th class="header">Phone Number</th>
			<th class="rightmost">&nbsp;</th>
			</tr>


			<c:forEach var="item" items="${entityList}">
             <tr style="cursor: pointer;">

              <td width="5%" class=""><input type="checkbox" value="${item.id}" id="person_1773"></td>
              <td width="20%" class=""><a class="underline" href="<s:url action="ledger" namespace="/reports"/>?customerId=${item.id}">${item.companyName}</a></td>
               <td width="20%" class="">${item.name}</td>

               <td width="20%" class="">${item.city}</td>
        <td width="30%" class=""><a class="underline" href="mailto:${item.email}">${item.email}</a></td>
        <td width="20%" class="">${item.primaryCell}</td>

             <td width="5%" class="rightmost"><a title="Update Supplier" class="thickbox" href="<s:url action="edit"/>?id=${item.id}"><img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a></td>

             </tr>
            </c:forEach>



			</table>
			</div>
			<div id="pagination">
							</div>
		</td>
	</tr>
</tbody></table>
<div id="feedback_bar"></div>
