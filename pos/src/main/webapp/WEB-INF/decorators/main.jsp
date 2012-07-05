<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<head>
	<meta content="text/html; charset=utf-8" http-equiv="content-type">
	<base href="">
	<title>Point Of Sale</title>
	<link type="image/x-icon" href="favicon.ico" rel="icon">
	<link href="${pageContext.request.contextPath}/css/phppos.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/menubar.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/general.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/popupbox.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/register.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/receipt.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/reports.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/tables.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/thickbox.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/datepicker.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/editsale.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/footer.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/css3.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/ui-lightness/jquery-ui-1.8.14.custom.css" rev="stylesheet" rel="stylesheet">
	<link media="print" href="${pageContext.request.contextPath}/css/phppos_print.css" rev="stylesheet" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/jquery.loadmask.css" rev="stylesheet" rel="stylesheet">



	<script type="text/javascript">
	var SITE_URL= "${pageContext.request.contextPath}";
	</script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.14.custom.min.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.color.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tablesorter.min.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/thickbox.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/manage_tables.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/date.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker.js"></script>
	<script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.loadmask.min.js"></script>
	<script type="text/javascript">
	Date.format = 'mm/dd/yyyy';
	</script>
<style type="text/css">
html {
    overflow: auto;
}
</style>
  <decorator:head/>
</head>
<body>
<div id="menubar">
	<table id="menubar_container">

		<tbody><tr id="menubar_navigation">
			<td class="menu_item menu_item_home">
				<a href=""><img alt="" src="${pageContext.request.contextPath}/images/header/header_logo.png"></a>
			</td>
						<td class="menu_item menu_item_customers">
				<a href="${pageContext.request.contextPath}/customers/">Customers</a>
			</td>
						<td class="menu_item menu_item_items">
				<a href="${pageContext.request.contextPath}/items/">Items</a>
			</td>
			<td class="menu_item menu_item_suppliers">
				<a href="${pageContext.request.contextPath}/suppliers/">Suppliers</a>
			</td>
			<td class="menu_item menu_item_payments">
				<a href="${pageContext.request.contextPath}/payments/">Payments</a>
			</td>

						<td class="menu_item menu_item_receivings">
				<a href="${pageContext.request.contextPath}/purchase/">Receivings</a>
			</td>
						<td class="menu_item menu_item_sales">
				<a href="${pageContext.request.contextPath}/sales/">Sales (F2)</a>
			</td>
						<td class="menu_item menu_item_employees">
				<a href="${pageContext.request.contextPath}/employees/">Employees</a>
			</td>
		    <td class="menu_item menu_item_reports">
				<a href="${pageContext.request.contextPath}/reports/">Reports</a>
			</td>
			<td class="menu_item menu_item_config">
				<a href="${pageContext.request.contextPath}/config/">Store Config</a>
			</td>
					</tr>

	</tbody></table>
</div>
<div id="content_area_wrapper">
<div id="content_area">

       <decorator:body/>
</div>
</div>
<table id="footer_info">
		<tr>
			<td id="menubar_footer">
			Welcome <b> <sec:authentication property="principal.username" />! | </b>
			<a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>			</td>

			<td class="menu_date" id="menubar_date_time">
             <jsp:useBean id="dateValue" class="java.util.Date" />
            <fmt:formatDate pattern="hh:mm"    value="${dateValue}" />
			</td>
			<td class="menu_date mini_date" id="menubar_date_day">
                    <fmt:formatDate pattern="E"    value="${dateValue}" />
				<br>
				 <fmt:formatDate pattern="a"    value="${dateValue}" />
		    </td>
			<td class="menu_date" id="menubar_date_spacer">
				|
			</td>
			<td class="menu_date" id="menubar_date_date">
                   <fmt:formatDate pattern="dd"    value="${dateValue}" />
			</td>
			<td class="menu_date mini_date" id="menubar_date_monthyr">
				 <fmt:formatDate pattern="MMM"    value="${dateValue}" />
				 <br>
              <fmt:formatDate pattern="yyyy"    value="${dateValue}" />
		    </td>
		</tr>
	</table>
	<div id="footer_spacer"></div>

	<table id="footer">
		<tbody><tr>
			<td id="footer_cred">

			</td>
			<td id="footer_version">

			</td>
		</tr>
	</tbody></table>



</body></html>