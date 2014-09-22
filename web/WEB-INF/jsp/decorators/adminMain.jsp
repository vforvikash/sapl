<%@ page contentType="text/html; charset=iso-8859-1" language="java"%>


<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><decorator:title default="Welcome to Sapl!" />
</title>
<decorator:head />
</head>
<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td colspan="3" width="100%">
				<!-- *****************Header Start***************** -->
			<%
 			if (request.getRequestURI().indexOf("public/") >= 0) {
 			%>
				<%@ include file="/WEB-INF/jsp/public/common/header.jsp"%>
			<%
			} else if (request.getRequestURI().indexOf("secure/") >= 0) {
			%>
				<%@ include file="/WEB-INF/jsp/secure/common/header.jsp"%>
			<%
			}
			%>
			</td>
			<!-- *****************Header End***************** -->
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td width="20%" valign="top" align="center">
				<!-- **********************Side Menu Start************************ -->
				<%
					if ((request.getRequestURI().indexOf("/admin/") >= 0)
							|| (request.getRequestURI().indexOf("/messages/") >= 0))
				%>
				<%@ include file="/WEB-INF/jsp/secure/common/adminLeftMenu.jsp"%>


				<!-- ***********************Side Menu End************************* -->
			</td>
			<td width="2%">&nbsp;</td>
			<td width="78%" valign="top">
				<decorator:body />
				<br/>
			</td>
		</tr>
	</table>

	<%
		if (request.getRequestURI().indexOf("public/") >= 0) {
	%>
	<%@ include file="/WEB-INF/jsp/public/common/footer.jsp"%>
	<%
		} else if (request.getRequestURI().indexOf("secure/") >= 0) {
	%>
	<%@ include file="/WEB-INF/jsp/secure/common/footer.jsp"%>
	<%
		}
	%>

</body>
</html>