<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductTypes</title>
<!--
<script type="application/javascript" src="<c:url value="/scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(productTypeId, row){
		var rows = document.getElementById("ProductTypeTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = productTypeId;
			document.f1.action='<c:url value="/secure/productType/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${productType != null}"><c:out value="${productType.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	productTypes - 	<c:out value="${productTypes}"/>,
productType - 	<c:out value="${productType}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="ProductTypeTable">
	<thead>
	<tr id="tableHead">
		<th>ProductType Id</th>
					<th>ProductTypeName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$productTypes == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${productTypes}" var="productTypeV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${productType != null && productTypeV.id == productType.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="productTypeRows" onclick="javascript:updateObjectId(<c:out value="${productTypeV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${productTypeV.id}"/>
						</td>
													<td>
								<c:out value="${productTypeV.productTypeName}"/>
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
			<td>ProductTypeName:</td>
			<td>
				<c:out value="${productType.productTypeName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editProductTypeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/productType/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createProductTypeBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/productType/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteProductTypeBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a productType to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/productType/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>