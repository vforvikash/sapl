<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grounds</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#GroundTable tr").not(':first').hover(
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
	function updateObjectId(groundId, row){
		var rows = document.getElementById("GroundTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = groundId;
			document.f1.action='<c:url value="/secure/ground/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${ground != null}"><c:out value="${ground.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	grounds - 	<c:out value="${grounds}"/>,
ground - 	<c:out value="${ground}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="GroundTable">
	<thead>
	<tr id="tableHead">
		<th>Ground Id</th>
					<th>GroundName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$grounds == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${grounds}" var="groundV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${ground != null && groundV.id == ground.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="groundRows" onclick="javascript:updateObjectId(<c:out value="${groundV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${groundV.id}"/>
						</td>
													<td>
								<c:out value="${groundV.groundName}"/>
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
			<td>GroundName:</td>
			<td>
				<c:out value="${ground.groundName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editGroundBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/ground/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createGroundBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/ground/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteGroundBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a ground to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/ground/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>