<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
var sizeIndex = 0;
$(document).ready(function(){
	$("#addMoreSize").click(function(){
		$("#sizeCol").before($('<input/>').attr("id", "groupSize_sizeList["+sizeIndex+"].sizeName").attr("name", "sizeList["+sizeIndex+"].sizeName").append("<br/>"));
		sizeIndex = sizeIndex + 1;
	});
});
</script>
</head>
<body>
<form:form action="save.htm" commandName="groupSize" name="createS" id="createS" method="POST">
<form:hidden path="id" id="groupSize_id"/>
action=<c:out value="${action}"/>
<table>

		<tr>
			<td>Name:</td>
			<td>
				<form:input path="name" id="groupSize_name"/>
			</td>
		</tr>

		<tr>
			<td>Description:</td>
			<td>
				<form:input path="description" id="groupSize_description"/>
			</td>
		</tr>

		<tr>
			<td>NoOfSizes:</td>
			<td>
				<form:input path="noOfSizes" id="groupSize_noOfSizes"/>
			</td>
		</tr>
		<tr>
			<td valign="top">Size</td>
			<td>
				<!--<form:input path="sizes" id="groupSize_sizes"/>-->
				<table>
					<tr>
						<td id="sizeCol">
							<c:if test="${action=='edit'}">
								<c:forEach items="${groupSize.sizeList}" var="size" varStatus="sizeCounter">
									<form:input path="sizeList[${sizeCounter.count}].sizeName" id="groupSize_sizeList[${sizeCounter.count}].sizeName"/>
									<br/>
								</c:forEach>
							</c:if>
						</td>
						<td>
							<input type="button" id="addMoreSize" value="Add Size"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	<tr>
		<td>&nbsp;</td>
		<td align="right">
			<c:if test="${action=='edit'}">
				<input type="button" id="createGroupSizeBtn" onclick='javascript:document.createS.action="update.htm"; document.createS.submit();' value="Update"/>
			</c:if>
			<c:if test="${action=='create'}">
				<input type="button" id="createGroupSizeBtn" onclick='javascript:document.createS.submit();' value="Create"/>
			</c:if>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>