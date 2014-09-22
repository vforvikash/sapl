<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Colours</title>
<!--
<script type="application/javascript" src="<c:url value="scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(colourId, row){
		var rows = document.getElementById("ColourTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = colourId;
			document.f1.action='<c:url value="/secure/colour/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${colour != null}"><c:out value="${colour.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	colours - 	<c:out value="${colours}"/>,
colour - 	<c:out value="${colour}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="ColourTable">
	<thead>
	<tr id="tableHead">
		<th>Colour Id</th>
					<th>ColourName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$colours == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${colours}" var="colourV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${colour != null && colourV.id == colour.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="colourRows" onclick="javascript:updateObjectId(<c:out value="${colourV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${colourV.id}"/>
						</td>
													<td>
								<c:out value="${colourV.colourName}"/>
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
			<td>ColourName:</td>
			<td>
				<c:out value="${colour.colourName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editColourBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/colour/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createColourBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/colour/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteColourBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a colour to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/colour/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>