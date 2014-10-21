<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to administer</title>
</head>
<body>

	<h1>Welcome to configuration management <sec:authorize access="isAuthenticated()"><sec:authentication property="principal.username" /></sec:authorize>!!! <%-- <br/>Message: <c:out value="${message}"/> --%></h1>
	
	<%-- <sec:authorize access="isAuthenticated()">
			<tr>
				<td>&lt;sec:authentication property='principal.username' /&gt;</td>
				<td><sec:authentication property="principal.username" />
				</td>
			</tr>
			<tr>
				<td>&lt;sec:authentication property='principal.enabled' /&gt;</td>
				<td><sec:authentication property="principal.enabled" />
				</td>
			</tr>
			<tr>
				<td>&lt;sec:authentication
					property='principal.accountNonLocked' /&gt;</td>
				<td><sec:authentication property="principal.accountNonLocked" />
				</td>
			</tr>
			
		</sec:authorize> --%>

</body>
</html>