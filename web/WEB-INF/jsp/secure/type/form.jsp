<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save.htm" commandName="type" name="createS" id="createS" method="POST">
<form:hidden path="id" id="type_id"/>
action=<c:out value="${action}"/>
<table>
		
		<tr>
			<td>TypeName:</td>
			<td>
				<form:input path="typeName" id="type_typeName"/>
			</td>
		</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td align="right">
			<c:if test="${action=='edit'}">
				<input type="button" id="createTypeBtn" onclick='javascript:document.createS.action="update.htm"; document.createS.submit();' value="Update"/>
			</c:if>
			<c:if test="${action=='create'}">
				<input type="button" id="createTypeBtn" onclick='javascript:document.createS.submit();' value="Create"/>
			</c:if>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>