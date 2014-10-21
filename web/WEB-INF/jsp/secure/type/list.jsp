<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Types</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#TypeTable tr").not(':first').hover(
		  function () {
		    $(this).css("background","#C0C0C0");
		  }, 
		  function () {
		    $(this).css("background","");
		  }
		);
	});
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(typeId, row){
		var rows = document.getElementById("TypeTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = typeId;
			document.f1.action='<c:url value="/secure/type/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${type != null}"><c:out value="${type.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	types - 	<c:out value="${types}"/>,
type - 	<c:out value="${type}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="TypeTable">
	<thead>
	<tr id="tableHead">
		<th>Type Id</th>
					<th>TypeName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$types == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${types}" var="tVar">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${type != null && tVar.id == type.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="typeRows" onclick="javascript:updateObjectId(<c:out value="${tVar.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${tVar.id}"/>
						</td>
													<td>
								<c:out value="${tVar.typeName}"/>
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
			<td>TypeName:</td>
			<td>
				<c:out value="${type.typeName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editTypeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/type/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createTypeBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/type/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteTypeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a type to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/type/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>