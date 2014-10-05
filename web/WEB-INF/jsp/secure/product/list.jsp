<%@ include file="/WEB-INF/jsp/secure/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<!--
<script type="application/javascript" src="<c:url value="/scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(productId, row){
		var rows = document.getElementById("ProductTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = productId;
			document.f1.action='<c:url value="/secure/product/view.htm"/>';
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
.NotSelected {
	background-color: #DFDFDF;
}

.Selected {
	background-color: #C0C0C0;
}
</style>
</head>
<body>
	<form id="f1" name="f1" method="get">
		<input id="objectId" name="objectId" type="hidden"
			value="<c:if test="${product != null}"><c:out value="${product.id}"/></c:if>" />
	</form>
	<!--
action=<c:out value="${action}"/>	products - 	<c:out value="${products}"/>,
product - 	<c:out value="${product}"/>
-->
	<table cellspacing="0" cellpadding="0" width="100%" border="1"
		id="ProductTable">
		<thead>
			<tr id="tableHead">
				<th>Product Id</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="$products == null">
					<tr>
						<td align="center"></td>
						<td align="center"></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${products}" var="productV">
						<c:set var="rowClass" value="NotSelected" />
						<c:if test="${product != null && productV.id == product.id}">
							<c:set var="rowClass" value="Selected" />
						</c:if>
						<tr id="productRows"
							onclick="javascript:updateObjectId(<c:out value="${productV.id}"/>, this);"
							class="<c:out value="${rowClass}"/>">
							<td><c:out value="${productV.id}" /></td>
							<td><c:out value="${productV.name}" /></td>
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
				<td><c:out value="${product.name}" /></td>
				<td>Colours:</td>
				<td>
					<c:forEach items="${product.colours}" var="colour">
						<c:out value="${colour.colourName}" /> <br/>
					</c:forEach>
				</td>
			</tr>
		</table>
	</c:if>

	<input id="editProductBtn" type="button"
		onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/product/edit.htm"/>'; document.f1.method='POST';document.f1.submit();"
		value="Edit" />
	<input id="createProductBtn" type="button"
		onclick="javascript:document.f1.action='<c:url value="/secure/product/create.htm"/>';document.f1.method='GET'; document.f1.submit();"
		value="Create" />
	<input id="deleteProductBtn" type="button"
		onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a product to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/product/delete.htm"/>'; document.f1.submit();"
		value="Delete" />

</body>
</html>