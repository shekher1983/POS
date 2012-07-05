<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <jsp:useBean id="dateValue" class="java.util.Date" />

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