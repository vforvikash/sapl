<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>

<!-- <script type="text/javascript" src="scripts/jquery-1.8.2.js"></script> -->
<script type="text/javascript" src="/sapl/dwr/engine.js"></script>
<script type="text/javascript" src="/sapl/dwr/util.js"></script>
<script type="text/javascript" src="/sapl/dwr/interface/ajaxController.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	closeAllDiv();
	$("#product_type.typeName").keyup(function(){
		var typeLike = $("#product_type.typeName").val();
		dwr.util.useLoadingMessage("Searching...");
		ajaxController.getListOfType(typeLike, {callback:showListByCallBack});
	});
});

var ajaxCallStr = "";
var divUsed = "";
function closeAllDiv(){
	$("#typeDiv").hide();
	$("#groupSizeDiv").hide();
	$("#productTypeDiv").hide();
	$("#groupDiv").hide();
	$("#groundDiv").hide();
	$("#loomDiv").hide();
	$("#colourDiv").hide();
	$("#textureDiv").hide();
}

function callSearchList(searchType){
	//var typeLike = $("#product_type.typeName").val();
	var searchString = "";
	ajaxCallStr = searchType;
	divUsed = "";
	//alert("typeLike="+typeLike);
	dwr.util.useLoadingMessage("Searching...");
	if(searchType=="TYPE"){
		divUsed = "#typeDiv";
		searchString = document.getElementById("product_type.typeName").value;
		document.getElementById("product_type.id").value = "";
	}else if(searchType=="GROUPSIZE"){
		divUsed = "#groupSizeDiv";
		searchString = document.getElementById("product_groupSize.name").value;
		document.getElementById("product_groupSize.id").value = "";
	}else if(searchType=="PRODUCTTYPE"){
		divUsed = "#productTypeDiv";
		searchString = document.getElementById("product_productType.productTypeName").value;
		document.getElementById("product_productType.id").value = "";
	}else if(searchType=="GROUP"){
		divUsed = "#groupDiv";
		searchString = document.getElementById("product_group.groupName").value;
		document.getElementById("product_group.id").value = "";
	}else if(searchType=="GROUND"){
		divUsed = "#groundDiv";
		searchString = document.getElementById("product_ground.groundName").value;
		document.getElementById("product_ground.id").value = "";
	}else if(searchType=="LOOM"){
		divUsed = "#loomDiv";
		searchString = document.getElementById("product_loom.loomName").value;
		document.getElementById("product_loom.id").value = "";
	}else if(searchType=="COLOUR"){
		divUsed = "#colourDiv";
		searchString = document.getElementById("product_colour.colourName").value;
		document.getElementById("product_colour.id").value = "";
	}else if(searchType=="TEXTURE"){
		divUsed = "#textureDiv";
		searchString = document.getElementById("product_texture.textureName").value;
		document.getElementById("product_texture.id").value = "";
	}
	ajaxController.getListOfDataSearched(searchString, searchType, {callback:showListByCallBack});
}


function setTypeData(id, name, idFld, nameFld){
	//alert("Hi..." + id + name + idFld + nameFld);
	$(divUsed).html("");
	$(divUsed).hide();
	document.getElementById(nameFld).value = name;
	document.getElementById(idFld).value = id;
}

function appendCloseLink(usedDiv){
	$(usedDiv).append('<a href="javascript:closeAllDiv();">CLOSE</a><br/>');
}

function showListByCallBack(dataList) {
	//alert(ajaxCallStr + ', dataList='+dataList);
	closeAllDiv();
	if(dataList == null){
		alert("list is null");
		return 0;
	}
	if(ajaxCallStr=="TYPE"){
		$("#typeDiv").html("");
		$("#typeDiv").show();
		appendCloseLink("#typeDiv");
		for(i=0; i < dataList.length; i++){
			var type = dataList[i];
			$("#typeDiv").append('<a href=\'javascript:setTypeData("'+type.id+'", "'+type.typeName+'", "product_type.id", "product_type.typeName");\' >'+ type.typeName +"</a><br/>");
		}
	}else if(ajaxCallStr=="GROUPSIZE"){
		$("#groupSizeDiv").html("");
		$("#groupSizeDiv").show();
		appendCloseLink("#groupSizeDiv");
		for(i=0; i < dataList.length; i++){
			var groupSize = dataList[i];
			$("#groupSizeDiv").append('<a href=\'javascript:setTypeData("'+groupSize.id+'", "'+groupSize.name+'", "product_groupSize.id", "product_groupSize.name");\' >'+ groupSize.name +"</a><br/>");
		}
	}else if(ajaxCallStr=="PRODUCTTYPE"){
		$("#productTypeDiv").html("");
		$("#productTypeDiv").show();
		appendCloseLink("#productTypeDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#productTypeDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.productTypeName+'", "product_productType.id", "product_productType.productTypeName");\' >'+ data.productTypeName +"</a><br/>");
		}
	}else if(ajaxCallStr=="GROUP"){
		$("#groupDiv").html("");
		$("#groupDiv").show();
		appendCloseLink("#groupDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#groupDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.groupName+'", "product_group.id", "product_group.groupName");\' >'+ data.groupName +"</a><br/>");
		}
	}else if(ajaxCallStr=="GROUND"){
		$("#groundDiv").html("");
		$("#groundDiv").show();
		appendCloseLink("#groundDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#groundDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.groundName+'", "product_ground.id", "product_ground.groundName");\' >'+ data.groundName +"</a><br/>");
		}
	}else if(ajaxCallStr=="LOOM"){
		$("#loomDiv").html("");
		$("#loomDiv").show();
		appendCloseLink("#loomDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#loomDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.loomName+'", "product_loom.id", "product_loom.loomName");\' >'+ data.loomName +"</a><br/>");
		}
	}else if(ajaxCallStr=="COLOUR"){
		$("#colourDiv").html("");
		$("#colourDiv").show();
		appendCloseLink("#colourDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#colourDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.colourName+'", "product_colour.id", "product_colour.colourName");\' >'+ data.colourName +"</a><br/>");
		}
	}else if(ajaxCallStr=="TEXTURE"){
		$("#textureDiv").html("");
		$("#textureDiv").show();
		appendCloseLink("#textureDiv");
		for(i=0; i < dataList.length; i++){
			var data = dataList[i];
			$("#textureDiv").append('<a href=\'javascript:setTypeData("'+data.id+'", "'+data.textureName+'", "product_texture.id", "product_texture.textureName");\' >'+ data.textureName +"</a><br/>");
		}
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save.htm" commandName="product" name="createS" id="createS" method="POST">
<form:hidden path="id" id="product_id"/>
<!-- action=<c:out value="${action}"/>-->
<form:errors path="*" cssClass="errorblock" element="div" />
<h3>Product <c:out value="${action}"/></h3>
<table>
<thead></thead>
		<tr>
			<td valign="top" width="15%">Name:</td>
			<td width="35%">
				<form:input path="name" id="product_name"/>
			</td>
		
			<td valign="top" width="15%">Indent House:</td>
			<td width="35%">
				<form:checkbox path="isIndentHouse" id="product_isIndentHouse"/>
			</td>
		</tr>
		<tr>
			<td valign="top">Length:</td>
			<td>
				<form:input path="length" id="product_length"/>
			</td>
		
			<td valign="top">Width:</td>
			<td>
				<form:input path="width" id="product_width"/>
			</td>
		</tr>
			<%--
		<tr>
			  <td>P Rate:</td>
			<td>
				<form:input path="p_rate" id="product_p_rate"/>
			</td>
			<td>S Rate:</td>
			<td>
				<form:input path="s_rate" id="product_s_rate"/>
			</td>
		</tr>
			 --%>
		<tr>
			<td valign="top">Description:</td>
			<td colspan="3">
				<form:textarea cols="50" rows="10" path="description" id="product_desc"/>
			</td>
		</tr>
		<tr>
			<td>Horizontal: <form:radiobutton path="productStyle" value="H"/></td>
			<td>
				Vertical: <form:radiobutton path="productStyle" value="V"/>
			</td>
			<td>Unit Type:</td>
			<td> 
				<form:select path="unitType">
					<form:option value="">Select Unit Type</form:option>
					<form:option value="INCH">Inch</form:option>
					<form:option value="CENTIMETER">Centimeter</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Woven: <form:radiobutton path="productSubType" value="Woven" /></td>
			<td>Printed: <form:radiobutton path="productSubType" value="Printed" /></td>
		</tr>
		<tr>
			<td valign="top">openingStock:</td>
			<td>
				<form:input path="openingStock" id="product_openingStock"/>
			</td>
			<td valign="top">closingStock:</td>
			<td>
				<form:input path="closingStock" id="product_closingStock"/>
			</td>
		</tr>
		<tr>
			<td valign="top">keepStock:</td>
			<td>
				<form:input path="keepStock" id="product_keepStock"/>
			</td>
			<td valign="top">Unit:</td>
			<td>
				<form:input path="unit" id="product_unit"/>
			</td>
		</tr>
		<tr>
			<td valign="top">salesPrice:</td>
			<td>
				<form:input path="salesPrice" id="product_salesPrice"/>
			</td>
			<td valign="top">purchasePrice:</td>
			<td>
				<form:input path="purchasePrice" id="product_purchasePrice"/>
			</td>
		</tr>
		<tr>
			<td valign="top">Type:</td>
			<td>
				<form:hidden path="type.id" id="product_type.id"/>
				<form:input path="type.typeName" id="product_type.typeName" onKeyUp="javascript:callSearchList('TYPE');"/>
				<div id="typeDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
			<td valign="top">groupSize:</td>
			<td>
				<form:hidden path="groupSize.id" id="product_groupSize.id"/>
				<form:input path="groupSize.name" id="product_groupSize.name" onKeyUp="javascript:callSearchList('GROUPSIZE');"/>
				<div id="groupSizeDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
		</tr>
		<tr>
			<td valign="top">productType:</td>
			<td>
				<form:hidden path="productType.id" id="product_productType.id"/>
				<form:input path="productType.productTypeName" id="product_productType.productTypeName" onKeyUp="javascript:callSearchList('PRODUCTTYPE')"/>
				<div id="productTypeDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
			<td valign="top">Group:</td>
			<td>
				<form:hidden path="group.id" id="product_group.id"/>
				<form:input path="group.groupName" id="product_group.groupName" onKeyUp="javascript:callSearchList('GROUP')"/>
				<div id="groupDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
		</tr>
		<tr>
			<td valign="top">ground:</td>
			<td>
				<form:hidden path="ground.id" id="product_ground.id"/>
				<form:input path="ground.groundName" id="product_ground.groundName" onKeyUp="javascript:callSearchList('GROUND')"/>
				<div id="groundDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
			<td valign="top">loom:</td>
			<td>
				<form:hidden path="loom.id" id="product_loom.id"/>
				<form:input path="loom.loomName" id="product_loom.loomName" onKeyUp="javascript:callSearchList('LOOM')"/>
				<div id="loomDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
		</tr>
		<tr>
			<td valign="top">colour:</td>
			<td>
				<%-- 
				<form:hidden path="colour.id" id="product_colour.id"/>
				<form:input path="colour.colourName" id="product_colour.colourName" onKeyUp="javascript:callSearchList('COLOUR')"/>
				<div id="colourDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div> --%>
				
				<form:select path="colours" id="product_colours.id" items="${colourList}" multiple="true" itemLabel="colourName" itemValue="id" cssStyle="width:100px;height:100px;"/>
				
			</td>
			<td valign="top">texture:</td>
			<td>
				<form:hidden path="texture.id" id="product_texture.id"/>
				<form:input path="texture.textureName" id="product_texture.textureName" onKeyUp="javascript:callSearchList('TEXTURE')"/>
				<div id="textureDiv" style="background-color:#aac;overflow-x:hidden;overflow-y:scroll;width:200px;height:100px;position:absolute;z-index:1;"><a href="javascript:closeAllDiv()" title="Close Me">CLOSE<a/><br/></div>
			</td>
		</tr>
	<tr>
		<td>&nbsp;</td>
		<td align="right">
			<c:if test="${action=='edit'}">
				<input type="button" id="createProductBtn" onclick='javascript:document.createS.action="update.htm"; document.createS.submit();' value="Update"/>
			</c:if>
			<c:if test="${action=='create'}">
				<input type="button" id="createProductBtn" onclick='javascript:document.createS.submit();' value="Create"/>
			</c:if>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>