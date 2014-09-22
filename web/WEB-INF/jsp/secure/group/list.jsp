<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups</title>
<!--
<script type="application/javascript" src="<c:url value="/scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(groupId, row){
		var rows = document.getElementById("GroupTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = groupId;
			document.f1.action='<c:url value="/secure/group/view.htm"/>';
			document.f1.method='POST';
			document.f1.submit();
		}else if(isSelected == "Selected"){
			row.className = "NotSelected";
			document.getElementById("objectId").value = "";
		}

	}

	function checkboxselected(checkmail){
		return false;
	}
</script>
<style type="text/css">
	.NotSelected{
		background-color: #DFDFDF;
	}

	.Selected{
		background-color: #C0C0C0;
	}
</style>
</head>
<body>
<form id="f1" name="f1" method="get">
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${group != null}"><c:out value="${group.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	groups - 	<c:out value="${groups}"/>,
group - 	<c:out value="${group}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="GroupTable">
	<thead>
	<tr id="tableHead">
		<th>Group Id</th>
					<th>GroupName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$groups == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${groups}" var="groupV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${group != null && groupV.id == group.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="groupRows" onclick="javascript:updateObjectId(<c:out value="${groupV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${groupV.id}"/>
						</td>
													<td>
								<c:out value="${groupV.groupName}"/>
							</td>
											</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<c:if test="${action == 'view'}">
<table>

		<tr>
			<td>GroupName:</td>
			<td>
				<c:out value="${group.groupName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editGroupBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/group/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createGroupBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/group/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteGroupBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a group to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/group/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>