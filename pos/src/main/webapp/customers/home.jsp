<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">

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

function init_table_sorting()
{
	initCityList();
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


  $(document).ready(function()
{

       init_table_sorting();
        enable_select_all();
        enable_checkboxes();
        enable_row_selection();
        enable_search('<s:url action="suggest"/>','You have selected one or more rows, these will no longer be selected after your search. Are you sure you want to submit this search?');

     $("#filter_customer_button").click(function()
              {
                 var options = {
                    target:     '#contents',

                    success:    function() {
                          $('#spinner').hide();
	                      tb_init('#sortable_table a.thickbox');

                    },
                    beforeSubmit: function(){
	                     $('#spinner').show();

                    }
                };

    	        $('#filter_customer_form').ajaxSubmit(options);
              });


	});



	</script>

<form action="<s:url action="list"/>" method="post" accept-charset="utf-8" id="filter_customer_form">

<div class='form_field'>
	City:<input type="text" id="city" name="city" value="${city}" id="name"  />
	    <input type="button" name="filter" id="filter_customer_button" value="filter"/>
       <img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif"/>
	</div>


</div>
</form>
<table id="title_bar">
	<tbody><tr>
		<td id="title_icon">
			<img alt="title icon" src="${pageContext.request.contextPath}/images/menubar/customers.png">
		</td>
		<td id="title">
			List of Customers		</td>
		<td id="title_search">
			<form id="search_form" accept-charset="utf-8" method="post" action="<s:url action="search"/>">
			<input type="text" id="search" name="search"  class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
			</form>
		</td>
		<td id="commands">
			<div id="new_button">
				<a title="New Customer" class="thickbox none new" href="<s:url action="new"/>">New Customer</a>
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
			<th class="leftmost">
			    <input type="checkbox" id="select_all">
			</th>
			<th class="header">Name</th>
            <th class="header headerSortDown">City</th>
			<th class="header">E-Mail</th>
			<th class="header">Phone Number</th>
			<th class="rightmost">&nbsp;</th>
			</tr>
			<thead>
			<tbody>
			<c:forEach var="item" items="${userEntities}">
             <tr style="cursor: pointer;">

              <td width="5%" class=""><input type="checkbox" value="${item.id}" id="person_1773"></td>
              <td width="20%" class=""><a class="underline" href="<s:url action="ledger" namespace="/reports"/>?customerId=${item.id}">${item.name}</a></td>
               <td width="20%" class="">${item.city}</td>
                 <td width="30%" class=""><a class="underline" href="mailto:${item.email}">${item.email}</a></td>
                 <td width="20%" class="">${item.primaryCell}</td>

             <td width="5%" class="rightmost">

             <a href="edit.php?id=585"></a>
             <a title="Update Customer" class="thickbox" href="<s:url action="edit"/>?id=${item.id}"><img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a></td>

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
