<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 [
 <c:forEach var="item" items="${products}">

    {"value":"${item.id}","label":"${item.name}"},
  </c:forEach>
 ]
