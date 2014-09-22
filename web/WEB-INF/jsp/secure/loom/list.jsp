<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Looms</title>
<!--
<script type="application/javascript" src="<c:url value="/scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(loomId, row){
		var rows = document.getElementById("LoomTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = loomId;
			document.f1.action='<c:url value="/secure/loom/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${loom != null}"><c:out value="${loom.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	looms - 	<c:out value="${looms}"/>,
loom - 	<c:out value="${loom}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="LoomTable">
	<thead>
	<tr id="tableHead">
		<th>Loom Id</th>
					<th>LoomName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$looms == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${looms}" var="loomV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${loom != null && loomV.id == loom.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="loomRows" onclick="javascript:updateObjectId(<c:out value="${loomV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${loomV.id}"/>
						</td>
													<td>
								<c:out value="${loomV.loomName}"/>
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
			<td>LoomName:</td>
			<td>
				<c:out value="${loom.loomName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editLoomBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/loom/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createLoomBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/loom/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteLoomBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a loom to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/loom/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>