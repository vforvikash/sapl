<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GroupSizes</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#GroupSizeTable tr").not(':first').hover(
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
	function updateObjectId(groupSizeId, row){
		var rows = document.getElementById("GroupSizeTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = groupSizeId;
			document.f1.action='<c:url value="/secure/groupSize/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${groupSize != null}"><c:out value="${groupSize.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	groupSizes - 	<c:out value="${groupSizes}"/>,
groupSize - 	<c:out value="${groupSize}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="GroupSizeTable">
	<thead>
	<tr id="tableHead">
		<th>GroupSize Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>NoOfSizes</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$groupSizes == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
											<td align="center">
						</td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${groupSizes}" var="groupS">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${groupS != null && groupS.id == groupSize.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="groupSizeRows" onclick="javascript:updateObjectId(<c:out value="${groupS.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${groupS.id}"/>
						</td>
													<td>
								<c:out value="${groupS.name}"/>
							</td>
													<td>
								<c:out value="${groupS.description}"/>
							</td>
													<td>
								<c:out value="${groupS.noOfSizes}"/>
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
			<td>Name:</td>
			<td>
				<c:out value="${groupSize.name}"/>
			</td>
		</tr>

		<tr>
			<td>Description:</td>
			<td>
				<c:out value="${groupSize.description}"/>
			</td>
		</tr>

		<tr>
			<td>NoOfSizes:</td>
			<td>
				<c:out value="${groupSize.noOfSizes}"/>
			</td>
		</tr>
		<tr>
			<td>Sizes:</td>
			<td>
				<c:forEach items="${groupSize.sizes}" var="size">
					<c:out value="${size.sizeName}"/> <br/> 
				</c:forEach>
			</td>
		</tr>
	</table>
</c:if>

<input id="editGroupSizeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/groupSize/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createGroupSizeBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/groupSize/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteGroupSizeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a groupSize to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/groupSize/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>