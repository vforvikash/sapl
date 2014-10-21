<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Textures</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#TextureTable tr").not(':first').hover(
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
	function updateObjectId(textureId, row){
		var rows = document.getElementById("TextureTable").rows;
		var isSelected = row.className;
		for(i=0; i < rows.length; i++){
			if(rows[i].id != "tableHead"){
				rows[i].className = "NotSelected";
			}
		}
		if(isSelected == "NotSelected"){
			row.className = "Selected";
			document.getElementById("objectId").value = textureId;
			document.f1.action='<c:url value="/secure/texture/view.htm"/>';
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
	<input id="objectId" name="objectId" type="hidden" value="<c:if test="${texture != null}"><c:out value="${texture.id}"/></c:if>"/>
</form>
<!--
action=<c:out value="${action}"/>	textures - 	<c:out value="${textures}"/>,
texture - 	<c:out value="${texture}"/>
-->
<table cellspacing="0" cellpadding="0" width="100%" border="1" id="TextureTable">
	<thead>
	<tr id="tableHead">
		<th>Texture Id</th>
					<th>TextureName</th>
			</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="$textures == null">
				<tr>
					<td align="center"></td>
											<td align="center">
						</td>
									</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${textures}" var="textureV">
					<c:set var="rowClass" value="NotSelected"/>
					<c:if test="${texture != null && textureV.id == texture.id}">
						<c:set var="rowClass" value="Selected"/>
					</c:if>
					<tr id="textureRows" onclick="javascript:updateObjectId(<c:out value="${textureV.id}"/>, this);" class="<c:out value="${rowClass}"/>">
						<td>
							<c:out value="${textureV.id}"/>
						</td>
													<td>
								<c:out value="${textureV.textureName}"/>
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
			<td>TextureName:</td>
			<td>
				<c:out value="${texture.textureName}"/>
			</td>
		</tr>
	</table>
</c:if>

<input id="editTextureBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a class to edit'); return false}; document.f1.action='<c:url value="/secure/texture/edit.htm"/>'; document.f1.method='POST';document.f1.submit();" value="Edit"/>
<input id="createTextureBtn" type="button" onclick="javascript:document.f1.action='<c:url value="/secure/texture/create.htm"/>';document.f1.method='GET'; document.f1.submit();" value="Create"/>
<input id="deleteTextureBtn" type="button" onclick="javascript:if(document.f1.objectId.value==''){alert('Please select a texture to delete'); return false}; document.f1.method='POST'; document.f1.action='<c:url value="/secure/texture/delete.htm"/>'; document.f1.submit();" value="Delete"/>

</body>
</html>