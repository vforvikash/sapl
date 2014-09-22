<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<!--
<script type="application/javascript" src="<c:url value="/scripts/jquery-1.8.2.js"/>"></script>
-->
<script type="text/javascript">
	function doWhat(action){
		window.location="";
	}
	function updateObjectId(customerId, row){
		var rows = document.getElementById("CustomerTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = customerId;
			document.f1.action='<c:url value="/secure/customer/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${customer != null}"><c:out value="${customer.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	customers - 	<c:out value="${customers}"/>,
customer - 	<c:out value="${customer}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="CustomerTable">
	<thead>
	<tr id="tableHead">
		<th>Customer Id</th>
					<th>Name</th>
					<th>ContactPerson</th>
					<th>Description</th>
					<th>Note</th>
					<th>Address</th>
					<th>Phone</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$customers == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
											<td align="center">
						</td>
											<td align="center">
						</td>
											<td align="center">
						</td>
											<td align="center">
						</td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${customers}" var="cust">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${customer != null && cust.id == customer.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="customerRows" onclick="javascript:updateObjectId(<c:out value="${cust.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${cust.id}"/>
						</td>
													<td>
								<c:out value="${cust.name}"/>
							</td>
													<td>
								<c:out value="${cust.contactPerson}"/>
							</td>
													<td>
								<c:out value="${cust.description}"/>
							</td>
													<td>
								<c:out value="${cust.note}"/>
							</td>
													<td>
								<c:out value="${cust.address}"/>
							</td>
													<td>
								<c:out value="${cust.phone}"/>
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
				<c:out value="${customer.name}"/>
			</td>
		</tr>
	
		<tr>
			<td>ContactPerson:</td>
			<td>
				<c:out value="${customer.contactPerson}"/>
			</td>
		</tr>
	
		<tr>
			<td>Description:</td>
			<td>
				<c:out value="${customer.description}"/>
			</td>
		</tr>
	
		<tr>
			<td>Note:</td>
			<td>
				<c:out value="${customer.note}"/>
			</td>
		</tr>
	
		<tr>
			<td>Address:</td>
			<td>
				<c:out value="${customer.address}"/>
			</td>
		</tr>
	
		<tr>
			<td>Phone:</td>
			<td>
				<c:out value="${customer.phone}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editCustomerBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/customer/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createCustomerBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/customer/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteCustomerBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a customer to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/customer/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>