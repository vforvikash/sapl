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
  $("#leftmenulink1").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/colour/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink2").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/ground/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink3").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/groupSize/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink4").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/group/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink5").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/loom/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink6").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/productType/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink7").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/texture/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink8").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/type/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink9").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/product/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
  $("#leftmenulink10").click(function(){
	  document.leftMenuForm.action='<c:url value="/secure/customer/list.htm"/>';
	  document.leftMenuForm.method='GET';
	  document.leftMenuForm.submit();
  });
});
</script>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td>
			<form id="leftMenuForm" name="leftMenuForm" method="get">
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink1">COLOUR</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink2">GROUND</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink3">GROUP SIZE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink4">GROUP</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink5">LOOM</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink6">PRODUCT TYPE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink7">TEXTURE</a> <BR/>
					</div>
				</div>

				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink8">TYPE</a> <BR/>
					</div>
				</div>
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink9">PRODUCT</a> <BR/>
					</div>
				</div>
				<div style="clear:both;width:200px;height:30px;" id="leftmenu">
					<div style="float:left;word-spacing:2px;font-size:90%;padding-left:15px;padding-top:6px;white-space:nowrap;text-align:left;">
						<a target="_top" href="#" class="leftmenu" id="leftmenulink10">CUSTOMER</a> <BR/>
					</div>
				</div>

			</form>
		</td>
	</tr>
</table>
