<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
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
                 <td colspan="2">Total Payment Amount</td>
                 <td><fmt:formatNumber value="${totalPaymentAmount}"  type="currency"/> </td>
                 </tr>
			</table>
			</c:if>