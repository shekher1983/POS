<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>

<HEAD>
<meta content="text/html; charset=utf-8" http-equiv="content-type">
<title> Point Of Sale Login</title>

<link href="${pageContext.request.contextPath}/css/login.css" rev="stylesheet" rel="stylesheet">
	 <script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
  <script charset="UTF-8" language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>

</HEAD>

<body onload="document.f.j_username.focus();">
	<div class="top_message" id="welcome_message">
		Welcome to the  Point Of Sale System. To continue, please login using your username and password below.					<h2>Press login to continue</h2>
			</div>
	<form accept-charset="utf-8" id="login_form" method="post" name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
	<div id="container">
	<div id="top">
		<img alt="" src="${pageContext.request.contextPath}/images/header/header_logo.png">	</div>
	<table id="login_form">
<c:if test="${not empty param.login_error}">
      <font color="red" id="error_message_box">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
		<tbody><tr id="form_field_username">
			<td class="form_field_label">Username: </td>
			<td class="form_field">
			 <input type='text' id="username" name='j_username' class="required" minlength="2" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
			 	</td>
		</tr>

		<tr id="form_field_password">
			<td class="form_field_label">Password: </td>
			<td class="form_field">
			<input type='password' id="password" name='j_password' class="required" minlength="5">			</td>
		</tr>

		<tr id="form_field_submit">
			<td colspan="2" id="submit_button">
				<input type="submit" value="Login" name="login_button">			</td>
		</tr>
	</tbody></table>
	<table id="bottom">
		<tbody><tr>
			<td id="left">
				<a href="login/reset_password">Reset password</a>
			</td>
			<td id="right">
				2012 Version 1.0			</td>
		</tr>
	</tbody></table>
</div>
</form>
</body>

<script type='text/javascript'>

//validation and submit handling
$(document).ready(function()
{

	var submitting = false;

	$('#login_form').validate();
});
</script>



