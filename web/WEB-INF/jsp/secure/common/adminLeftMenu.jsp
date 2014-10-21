<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<style>
#leftmenu {
    background-color: #EEEEEE;
    background-image: url(<c:url value="/images/leftmenu_bg.gif"/>);
    background-position: center bottom;
    background-repeat: repeat-x;
    margin: 5px 0 10px;
    padding: 0;
}

a.leftmenu:link, a.leftmenu:visited {
    color: #555555;
    text-decoration: none;
}
a.leftmenu:hover, a.leftmenu:active {
    color: #FF4800;
    text-decoration: none;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" ></script>
<%-- <script type="text/javascript" src="<c:url value="scripts/jquery-1.8.2.js"/>"></script> --%>
<script>
$(document).ready(function(){
  $("#COLOUR").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/colour/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#GROUND").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/ground/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#GROUP_SIZE").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/groupSize/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#GROUP").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/group/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#LOOM").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/loom/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#PRODUCT_TYPE").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/productType/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#TEXTURE").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/texture/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#TYPE").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/type/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#PRODUCT").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/product/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#CUSTOMER").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/customer/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  
  $("#<c:out value="${module}"/>").parent().parent().css("background", "gold");

});

</script>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td>
			<form id="leftMenuForm" name="leftMenuForm" method="get">
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="COLOUR">COLOUR</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="GROUND">GROUND</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="GROUP_SIZE">GROUP SIZE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="GROUP">GROUP</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="LOOM">LOOM</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="PRODUCT_TYPE">PRODUCT TYPE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="TEXTURE">TEXTURE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="TYPE">TYPE</a> <BR/>
					</div>
				</div>
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="PRODUCT">PRODUCT</a> <BR/>
					</div>
				</div>
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="CUSTOMER">CUSTOMER</a> <BR/>
					</div>
				</div>

			</form>
		</td>
	</tr>
</table>
