<div id="content_area">
<script type="text/javascript">
$(document).ready(function()
{
    init_table_sorting();
    enable_select_all();
    enable_checkboxes();
    enable_row_selection();
    enable_search('${pageContext.request.contextPath}/items/suggest','You have selected one or more rows, these will no longer be selected after your search. Are you sure you want to submit this search?');
    enable_delete('Are you sure you want to delete the selected items?','You have not selected any items to edit');
    enable_bulk_edit('You have not selected any items to edit');
    enable_cleanup('Are you sure you want to clean ALL deleted items? (This will remove item numbers from delete items so they can be reused)');

    $('#generate_barcodes').click(function()
    {
    	var selected = get_selected_values();
    	if (selected.length == 0)
    	{
    		alert('You must select at least 1 item to generate barcodes');
    		return false;
    	}

    	$(this).attr('href','${pageContext.request.contextPath}/items/generate_barcodes/'+selected.join('~'));
    });

	$('#generate_barcode_labels').click(function()
    {
    	var selected = get_selected_values();
    	if (selected.length == 0)
    	{
    		alert('You must select at least 1 item to generate barcodes');
    		return false;
    	}

    	$(this).attr('href','${pageContext.request.contextPath}/items/generate_barcode_labels/'+selected.join('~'));
    });
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
				0: { sorter: false},
				8: { sorter: false},
				9: { sorter: false}
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
			<form id="search_form" accept-charset="utf-8" method="post" action="${pageContext.request.contextPath}/items/search">				<input type="text" id="search" name="search" class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list" aria-haspopup="true">
				<img id="spinner" alt="spinner" src="${pageContext.request.contextPath}/images/spinner_small.gif">
			</form>
		</td>
	</tr>
</tbody></table>
<table id="contents">
	<tbody><tr>
		<td id="commands">
			<div id="new_button">
				<a title="New Item" class="thickbox none new" href="${pageContext.request.contextPath}/items/new.ps">New Item</a>
				<a title="Editing Multiple Items" class="bulk_edit_inactive" id="bulk_edit" href="${pageContext.request.contextPath}/items/bulk_edit/width~550">Bulk Edit</a>				<a title="Barcode Labels" target="_blank" class="generate_barcodes_inactive" id="generate_barcode_labels" href="${pageContext.request.contextPath}/items/generate_barcode_labels">Barcode Labels</a>				<a title="Barcode Sheet" target="_blank" class="generate_barcodes_inactive" id="generate_barcodes" href="${pageContext.request.contextPath}/items/generate_barcodes">Barcode Sheet</a>				
				<a title="Import Items from Excel" class="thickbox none import" href="${pageContext.request.contextPath}/items/excel_import/width~550">Excel Import</a>				
				<a class="none import" href="${pageContext.request.contextPath}/items/excel_export">Excel Export</a>
				<a class="delete_inactive" id="delete" href="${pageContext.request.contextPath}/items/delete">Delete</a>				<a class="cleanup" id="cleanup" href="${pageContext.request.contextPath}/items/cleanup">Cleanup Old Items</a>			</div>
		</td>
		<td style="width:10px;"></td>
		<td id="item_table">
			<div id="table_holder">
			<table id="sortable_table" class="tablesorter"><thead>
			<tr><th class="leftmost"><input type="checkbox" id="select_all"></th>
			<th class="header headerSortDown">UPC/EAN/ISBN</th><th class="header">Item Name</th>
			<th class="header">Category</th><th class="header">Cost Price</th>
			<th class="header">Unit Price</th><th class="header">Tax Percent(s)</th>
			<th class="header">Quantity</th><th class="">Inventory</th>
			<th class="rightmost">&nbsp;</th>
			</tr>
			</thead>
			<tbody>
			<tr><td width="3%"><input type="checkbox" value="6178" id="item_6178"></td>
			<td width="15%"></td><td width="15%">et</td><td width="11%">fa</td><td width="11%" align="right">$12.00</td><td width="11%" align="right">$12.00</td><td width="11%">7.000%</td><td width="11%">14.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6178/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6178/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6178/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6179" id="item_6179"></td><td width="15%"></td><td width="15%">food</td><td width="11%">foood 2</td><td width="11%" align="right">$15.00</td><td width="11%" align="right">$15.00</td><td width="11%">7.000%</td><td width="11%">11.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6179/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6179/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6179/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6174" id="item_6174"></td><td width="15%"></td><td width="15%">hd-sony</td><td width="11%">hdd</td><td width="11%" align="right">$50.00</td><td width="11%" align="right">$60.00</td><td width="11%"></td><td width="11%">8.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6174/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6174/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6174/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6182" id="item_6182"></td><td width="15%"></td><td width="15%">Ihene</td><td width="11%">Inkoko</td><td width="11%" align="right">$30.00</td><td width="11%" align="right">$35.00</td><td width="11%"></td><td width="11%">80.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6182/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6182/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6182/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6173" id="item_6173"></td><td width="15%"></td><td width="15%">MP3 Shuffle 2 GBs</td><td width="11%">Equipos</td><td width="11%" align="right">$30.00</td><td width="11%" align="right">$70.00</td><td width="11%"></td><td width="11%">41.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6173/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6173/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6173/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6180" id="item_6180"></td><td width="15%"></td><td width="15%">test 1</td><td width="11%">test 2</td><td width="11%" align="right">$50.00</td><td width="11%" align="right">$70.00</td><td width="11%"></td><td width="11%">15.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6180/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6180/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6180/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6175" id="item_6175"></td><td width="15%">1</td><td width="15%">hd--lg</td><td width="11%">hdd</td><td width="11%" align="right">$10.00</td><td width="11%" align="right">$12.00</td><td width="11%"></td><td width="11%">17.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6175/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6175/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6175/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6176" id="item_6176"></td><td width="15%">123456789</td><td width="15%">Libro I</td><td width="11%">Novela</td><td width="11%" align="right">$20.00</td><td width="11%" align="right">$20.00</td><td width="11%"></td><td width="11%">22.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6176/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6176/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6176/width~550">Edit</a></td></tr><tr><td width="3%"><input type="checkbox" value="6184" id="item_6184"></td><td width="15%">4800361375061</td><td width="15%">bear brand</td><td width="11%">milk</td><td width="11%" align="right">$90.00</td><td width="11%" align="right">$100.00</td><td width="11%">2.000%</td><td width="11%">200.00</td><td width="8%"><a title="Update Inventory" class="thickbox" href="${pageContext.request.contextPath}/items/inventory/6184/width~550">inv</a>&nbsp;&nbsp;&nbsp;&nbsp;<a title="Inventory Count Details" class="thickbox" href="${pageContext.request.contextPath}/items/count_details/6184/width~550">details</a></td><td width="4%" class="rightmost"><a title="Update Item" class="thickbox" href="${pageContext.request.contextPath}/items/view/6184/width~550">Edit</a></td></tr></tbody></table>			</div>
			<div id="pagination">
							</div>
		</td>
	</tr>
</tbody></table>
<div id="feedback_bar"></div>
</div>