<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<table id="contents">
	<tbody><tr>

		<td id="item_table">
			<div id="table_holder">
			<table id="sortable_table" class="tablesorter"><thead>
			<tr><th class="leftmost"><input type="checkbox" id="select_all"></th>
			<th class="header">Name</th>
            <th class="header headerSortDown">City</th>
			<th class="header">E-Mail</th>
			<th class="header">Phone Number</th>
			<th class="rightmost">&nbsp;</th>
			</tr>
			<thead>



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



			</table>
			</div>
			<div id="pagination">
							</div>
		</td>
	</tr>
</tbody></table>

