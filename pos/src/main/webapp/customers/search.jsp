<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<c:forEach var="item" items="${userEntities}">

<tr>
<td width='5%'><input type='checkbox' id='person_303' value='${item.id}'/></td>
<td width="20%"><a href="0" class="underline">${item.name}</a></td>
<td width="20%"><a href="0" class="underline">${item.city}</a></td>
<td width="30%"><a href="mailto:${item.email}" class="underline">${item.email}</a></td>
 <td width="20%" class="">${item.primaryCell}</td>

<td width="5%" class="rightmost">
<a href="<s:url action="edit"/>?id=${item.id}" class="thickbox" title="Update Customer">
<img alt="Edit" title="Edit" src="${pageContext.request.contextPath}/images/new/pencil.png"></a>
</a>
</td>
</tr>
</c:forEach>