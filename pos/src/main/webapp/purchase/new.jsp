<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

 <div class="sales" id="register_container">
<div id="TB_load"><img src="${pageContext.request.contextPath}/images/loading_animation.gif"></div>
<table>
	<tr>
		<td id="register_items_container">
			<table id="title_section">
				<tr>
					<td id="title_icon">
						<img src='${pageContext.request.contextPath}/images/menubar/receivings.png' alt='title icon' />
					</td>
					<td id="title">
						Items Receiving
					</td>
					<td id="register_wrapper">
						<form action="<s:url action="changeMode"/>" method="post" accept-charset="utf-8" id="mode_form">
						<span>Register Mode</span>
						<select name="mode" id="mode">
                <option value="1" <c:if test="${orderEntity.orderType.id == 1 }" >selected="selected"</c:if>>Receive</option>
                <option value="2" <c:if test="${orderEntity.orderType.id == 2 }" >selected="selected"</c:if>>Return</option>
                </select>
            </form>
	</td>
					<td id="show_suspended_sales_button">
						<a href="<s:url action="suspended"/>" class="thickbox none" title="Suspended Sales">
						<div class='small_button'>Suspended Sales</div></a>
					</td>
				</tr>
			</table>
			<div id="reg_item_search">
				<form action="<s:url action="addItem"/>" method="post" accept-charset="utf-8" id="add_item_form">
					<input type="text" name="itemId" value="" id="item" size="40" accesskey="i"  />
					<div id="new_item_button_register" >
						<a href="<s:url action="new" namespace="items" />" class="thickbox none" title="New Item">
						    <div class='small_button'>
						    <span>New Item</span>
						    </div>
						    </a>
						</div>
				</form>
			</div>
			<div id="register_holder">
			<table id="register">

				<thead>
					<tr>
						<th id="reg_item_del"></th>
						<th id="reg_item_number">Item Name</th>
						<th id="reg_item_stock">Stock</th>
						<th id="reg_item_price">Cost</th>
                        <th id="reg_item_qty">Qty.</th>
						<th id="reg_item_discount">Disc </th>
						<th id="reg_item_total">Total</th>
					</tr>
				</thead>
				<tbody id="cart_contents">


                    <c:choose>

                 <c:when test="${!empty orderEntity.itemList}">
                   <c:forEach var="item" items="${orderEntity.itemList}">
						<tr>
								<td colspan='8'>
                                <form action="<s:url action="editItem"/>?itemId=${item.product.id}" method="post" accept-charset="utf-8" class="line_item_form">
                                <table>
                                           <tr id="reg_item_top">
	                                           <td id="reg_item_del" ><a href="<s:url action="deleteItem" />?itemId=${item.product.id}" class="delete_item">Delete</a></td>
                                               <td id="reg_item_name"><a href="${pageContext.request.contextPath}/items/edit.ps?id=${item.product.id}" class="thickbox none" >${item.product.name}</a></td>
												<td id="reg_item_stock" >${item.product.stockQuantity}</td>
                                                <td id="reg_item_price"><input type="text" name="price" value="${item.salePrice}" size="6" id="price_3"  /></td>
												<td id="reg_item_qty"> <input type="text" name="quantity" value="${item.quantity}" />
												</td>
												<td id="reg_item_discount"><input type="text" name="discount" value="${item.discount}" size="3" id="discount_3"  /></td>
												<td id="reg_item_total"><fmt:formatNumber value="${item.totalAmount}"  type="currency"/> </td>
                                           <tr id="reg_item_bottom">
												<td id="reg_item_descrip_label">Desc:</td>
												<td colspan="4" id="reg_item_descrip">

                                                    <input type="text" value="${item.product.description}" name="description">
												</td>
												<td id="reg_item_serial_label">Sale Price

												</td>
												<td colspan="2" id="reg_item_serial">

                                                    <input type="text" value="${item.product.salePrice}" name="salePrice">
												</td>
											</tr>

									</table>
								</form>
							</tr>
						</td>

                        </tr>
                      </c:forEach>
                 </c:when>
               <c:otherwise>
                  <tr>
						<td colspan="8" style="height:60px;border:none;">
								<div class="warning_message" style="padding:7px;">There are no items in the cart</div>
						</td>
					</tr>

           </c:otherwise>
          </c:choose>








				</table>
			</div>

			<div id="reg_item_base"></div>
					</td>
		<td style="width:8px;"></td>
		<td id="over_all_sale_container">
			<div id="overall_sale">


				   <c:if test="${!empty orderEntity.itemList}">
				<div id="suspend_cancel">
					<div id="suspend" style='visibility: visible;'>
														<div class='small_button' id='suspend_sale_button'>
									<span>Suspend Sale</span>
								</div>
											</div>
					<div id="cancel" style='visibility: visible;'>
													<form action="<s:url action="cancel"/>" method="post" accept-charset="utf-8" id="cancel_sale_form">								<div class='small_button' id='cancel_sale_button'>
									<span>Cancel Sale</span>
								</div>
							</form>
											</div>
				</div>
                  </c:if>

				<div id="customer_info_shell">


            <c:choose>

                 <c:when test="${!empty orderEntity.customer}">
                    <div id="customer_info_filled">
		                <div id="customer_name">${orderEntity.customer.name}</div>
		                <div id="customer_email">${orderEntity.customer.address},${orderEntity.customer.city}</div>
		                <div id="customer_edit"><a title="Update Supplier" class="thickbox none" href="<s:url action="edit" namespace="/suppliers"/>?id=${orderEntity.customer.id}"><img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a></div>
		                <div id="customer_remove">
		                <a id="delete_customer" href="<s:url action="deleteCustomer"/>">Detach</a>
		                </div>
		            </div>
                 </c:when>
               <c:otherwise>
                  <div id='customer_info_empty'>
							<form action="<s:url action="addCustomer"/>" method="post" accept-charset="utf-8" id="select_customer_form">
							<label id="customer_label" for="customer">
								Select Supplier (Optional)
								</label>
							<input type="text" name="customerId" value="Type supplier's name..." id="customer" size="30" accesskey="c"  />							</form>
							<div id="add_customer_info">
								<div id="common_or">
									OR
							    </div>
								<a href="<s:url action="new" namespace="/suppliers"/>" class="thickbox none" title="New Supplier">
								<div class='small_button' style='margin:0 auto;'> <span>New Supplier</span> </div></a>
								</div>
							<div class="clearfix">&nbsp;</div>
						</div>
           </c:otherwise>
          </c:choose>




				</div>

				<div id='sale_details'>
					<table id="sales_items">
						<tr>
							<td class="left">Items In Cart:</td>
							<td class="right">${fn:length(orderEntity.itemList)}</td>
						</tr>
						<tr>
							<td class="left">Sub Total:</td>
							<td class="right">${orderEntity.subTotalAmount}</td>
						</tr>

                        <c:if test="${!empty orderEntity.discount && !empty orderEntity.itemList}">
                           <tr>
                            <td colspan="2">
                             <table>
                             <tr>
                             <td id="pt_delete">
								<a href="<s:url action="deleteDiscount"/>" class="delete_discount">[Delete]</a>
								</td>
                              <td  > Discount:</td>
							 <td class="right"><fmt:formatNumber value="${orderEntity.discount}"  type="currency"/> </td>
                             </tr>
                            </table>
                           </td>
						</tr>
                        </c:if>
                        <c:if test="${!empty orderEntity.shippingAmount && !empty orderEntity.itemList}">
                           <tr>
                            <td colspan="2">
                             <table>
                             <tr>
                             <td id="pt_delete">
								<a href="<s:url action="deleteShipping"/>" class="delete_shipping">[Delete]</a>
								</td>
                              <td> Shipping:</td>
							 <td class="right"><fmt:formatNumber value="${orderEntity.shippingAmount}"  type="currency"/> </td>
                             </tr>
                            </table>
                           </td>
						</tr>

                         </c:if>
											</table>
					<table id="sales_items_total">
						<tr>
							<td class="left">Total:</td>
							<td class="right"><fmt:formatNumber value="${orderEntity.totalAmount}"  type="currency"/>  </td>
						</tr>
					</table>
				</div>



                    <c:if test="${ !empty orderEntity.itemList}">

                     <div id="Shipping_Types">

						<div id="make_payment">
							<form id="add_shipping_button" accept-charset="utf-8" method="post" action="<s:url action="addShipping"/>">
							<table id="make_payment_table">
								<tr id="mpt_top">
									<td id="add_payment_text">
										Shipping:
									</td>

								</tr>
								<tr id="mpt_bottom">
									<td colspan="2" id="tender">
										<input type="text" accesskey="p" size="10" id="amount_shipping" value="${orderEntity.shippingAmount}" name="shippingAmount">	</td>
								</tr>
							</table>
							</form>
						</div>
					</div>
					<div id="Shipping_Types">

						<div id="make_payment">
							<form id="add_discount_button" accept-charset="utf-8" method="post" action="<s:url action="addDiscount"/>">
							<table id="make_payment_table">
								<tr id="mpt_top">
									<td id="add_payment_text">
										Discount:
									</td>

								</tr>
								<tr id="mpt_bottom">
									<td colspan="2" id="tender">
										<input type="text" accesskey="p" size="10" id="amount_discount" value="${orderEntity.discount}" name="discount">	</td>
								</tr>
							</table>
							</form>
						</div>
					</div>
                      <div id="Payment_Types" >
                     <c:if test="${ !empty orderEntity.paymentList}">

                      <table id="register">

							<tr>
							<th id="pt_delete"></th>
							<th id="pt_type">Type</th>
							<th id="pt_amount">Amount</th>


							</tr>
							  <c:forEach var="item" items="${orderEntity.paymentList}">

							   <tr>
								<td id="pt_delete">
								<a class="delete_payment" href="<s:url action="deletePayment"/>?paymentType=${item.type.id}">[Delete]</a>
								</td>
								<td id="pt_type">${item.type.name} </td>
								<td id="pt_amount"><fmt:formatNumber value="${item.amount}"  type="currency"/>   </td>
								</tr>
								 </c:forEach>
							</table>
                          </c:if>
						<table id="amount_due">
						<tr class="">
							<td>
								<div class="float_left" style="font-size:.8em;">Amount Due:</div>
							</td>
							<td style="text-align:right; ">

								<div class="float_left" style="text-align:right;font-weight:bold;">
								<fmt:formatNumber value="${orderEntity.dueAmount}"  type="currency"/>
								 </div>

							</td>
						</tr>
					</table>
                       <div id="make_payment">
							<form action="<s:url action="addPayment"/>" method="post" accept-charset="utf-8" id="add_payment_form">
							<table id="make_payment_table">
								    <s:select label="Payment"  name="paymentType" id="payment_types" listKey="id" listValue="name" list="paymentTypes" />

								<tr id="mpt_bottom">
									<td id="tender" colspan="2">
										<input type="text" name="paymentAmount" value="${orderEntity.dueAmount}" id="amount_tendered" size="10" accesskey="p"  />									</td>
								</tr>
							</table>
							<div class='small_button' id='add_payment_button'>
								<span>Add Payment</span>
							</div>
							</form>
						</div>
                        <c:if test="${orderEntity.dueAmount <= 0 }" >
                        <div id="finish_sale">
							<form id="finish_sale_form" accept-charset="utf-8" method="post" action="<s:url action="complete"/>">
							    <label for="comment" id="comment_label">Comments:</label>
							    <textarea accesskey="o" id="comment" rows="1" cols="40" name="comment">${orderEntity.note}</textarea>
							    <div style="float:left;margin-top:5px;" id="finish_sale_button" class="small_button">
							    <span>Complete Sale</span>
							    </div>
							</form>
						</div>
						 </c:if>
                    </c:if>

					</div>


			</div><!-- END OVERALL-->
		</td>
	</tr>
</table>
</div>
<div id="feedback_bar"></div>

<script type="text/javascript">

</script>

<script type="text/javascript" language="javascript">
$(document).ready(function()
{
	var my_ar = new Array ("reg_item_total","reg_item_discount", "reg_item_qty", "reg_item_price", "reg_item_stock", "reg_item_number", "reg_item_name", "reg_item_del");
	for (i=0; i < my_ar.length; i++ )
	{
		my_th = $("th#" + my_ar[i]);
		my_td = $("td#" + my_ar[i]);
		my_td.each(function (i)
		{
			$(this).width(my_th.width());
		});
	}

 	$('a.thickbox, area.thickbox, input.thickbox').each(function(i)
	{
		$(this).unbind('click');
    });

	tb_init('a.thickbox, area.thickbox, input.thickbox');

	$('#add_item_form, #mode_form, #select_customer_form, #add_payment_form').ajaxForm({target: "#register_container"});

	$("#cart_contents input").change(function()
	{
		var toFocusId = $(":input[type!=hidden]:eq("+($(":input[type!=hidden]").index(this) + 1) +")").attr('id');
		$(this.form).ajaxSubmit({target: "#register_container", success: function()
		{
			$('#' + toFocusId).focus();
		}
		});
	});

	$( "#item" ).autocomplete({
		source: '<s:url action="suggest" namespace="/items" />',
		delay: 10,
		autoFocus: false,
		minLength: 0,
		select: function(event, ui)
		{
 			event.preventDefault();
 			$( "#item" ).val(ui.item.value);
			$('#add_item_form').ajaxSubmit({target: "#register_container"});
		},
		change: function(event, ui)
		{
			if ($(this).attr('value') != '' && $(this).attr('value') != "Type item name or scan barcode...")
			{
				$("#add_item_form").ajaxSubmit({target: "#register_container"});
			}

    		$(this).attr('value',"Type item name or scan barcode...");
		}
	});

	$('#item').focus();

	$('#item,#customer').click(function()
    {
    	$(this).attr('value','');
    });

	$( "#customer" ).autocomplete({
		source: '<s:url action="suggest" namespace="/suppliers"/>',
		delay: 10,
		autoFocus: false,
		minLength: 0,
		select: function(event, ui)
		{
			$("#customer").val(ui.item.value);
			$('#select_customer_form').ajaxSubmit({target: "#register_container"});
		}
	});

    $('#customer').blur(function()
    {
    	$(this).attr('value',"Type supplier's name...");
    });

	$('#comment').change(function()
	{
		$.post('<s:url action="setComment"/>', {comment: $('#comment').val()});
	});


$('#amount_shipping').change(function()
	{
		$('#add_shipping_button').ajaxSubmit({target: "#register_container"});
	});

	$('#amount_discount').change(function()
	{
		$('#add_discount_button').ajaxSubmit({target: "#register_container"});
	});



	$('#email_receipt').change(function()
	{
		$.post('${pageContext.request.contextPath}/sales/set_email_receipt', {email_receipt: $('#email_receipt').is(':checked') ? '1' : '0'});
	});


    $("#finish_sale_button").click(function()
    {
    	if (confirm('Are you sure you want to submit this sale? This cannot be undone.'))
    	{
    		$('#finish_sale_form').submit();
    	}
    });

	$("#suspend_sale_button").click(function()
	{
		if (confirm('Are you sure you want to suspend this sale?'))
    	{
			$("#register_container").load('<s:url action="suspend"/>');
    	}
	});

    $("#cancel_sale_button").click(function()
    {
    	if (confirm('Are you sure you want to clear this sale? All items will cleared.'))
    	{
			$('#cancel_sale_form').ajaxSubmit({target: "#register_container"});
    	}
    });

	$("#add_payment_button").click(function()
	{
		$('#add_payment_form').ajaxSubmit({target: "#register_container"});
    });



	$("#payment_types").change(checkPaymentTypeGiftcard).ready(checkPaymentTypeGiftcard);
	$('#mode').change(function()
	{
		$('#mode_form').ajaxSubmit({target: "#register_container"});
	});

	$('.delete_item, .delete_payment, #delete_customer').click(function(event)
	{
		event.preventDefault();
		$("#register_container").load($(this).attr('href'));
	});
});

function post_item_form_submit(response)
{
	if(response.success)
	{
		$("#item").attr("value",response.item_id);
		$('#add_item_form').ajaxSubmit({target: "#register_container"});

	}
}

function post_person_form_submit(response)
{
	if(response.success)
	{
		if ($("#select_customer_form").length == 1)
		{
			$("#customer").attr("value",response.person_id);
			$('#select_customer_form').ajaxSubmit({target: "#register_container"});
		}
		else
		{
			$("#register_container").load('${pageContext.request.contextPath}/sales/reload');
		}
	}
}

function checkPaymentTypeGiftcard()
{
	if ($("#payment_types").val() == "Gift Card")
	{
		$("#amount_tendered_label").html("Gift Card Number");
		$("#amount_tendered").val('');
		$("#amount_tendered").focus();
	}
	else
	{
		$("#amount_tendered_label").html("Amount Tendered");
	}
}

</script>