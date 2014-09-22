<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script type="text/javascript" src="/sapl/dwr/engine.js"></script>
<script type="text/javascript" src="/sapl/dwr/util.js"></script>
<script type="text/javascript" src="/sapl/dwr/interface/ajaxController.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAPL Ajax Test</title>
<script type="text/javascript">
function callAjaxFunction(){
	dwr.util.useLoadingMessage();
	ajaxController.checkOutDwr({callback:getDataFromServerCallBack});
}

function getDataFromServerCallBack(dataFromServer) {
	var data = DWRUtil.toDescriptiveString(dataFromServer, 3);
	$("h1").after(data+"<br/>");
}

function callListSamples(){
	ajaxController.getSamples("vikash_sample_id", {callback:showSamples});
}

function showSamples(samples){
	for(i=0; i < samples.length; i++){
		var sample = samples[i];
		//var select = document.getElementById("Size");
		//select.options[select.options.length] = new Option(sample.name, sample.name+'_'+i);
		$("#Size").append($('<option></option>').val(sample.name).html(sample.name));
	}
}
</script>
</head>
<body>
	<h1>AJAX Test</h1>
	<input type="button" onclick="javascript: callAjaxFunction();" value="Call DWR"/>
	<input type="button" onclick="javascript: callListSamples();" value="Call Samples"/>

	<select id="Size">
	</select>
</body>
</html>