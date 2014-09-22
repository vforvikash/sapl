<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title><decorator:title default="Welcome to Sapl!" /></title>
		<decorator:head />
		<%@ include file="/WEB-INF/jsp/secure/common/resourceInclude.jsp" %>
	</head>

	<body>

	<TABLE border="0" cellspacing="0" cellpadding="0" width="100%">
<TR>
	<TD colspan="2" width="100%">
			<!-- *****************Header Start***************** -->
	<%	if (request.getRequestURI().indexOf("public/") >= 0 ){ %>
		<%@ include file="/WEB-INF/jsp/public/common/header.jsp" %>
	<%  }else if (request.getRequestURI().indexOf("secure/") >= 0){ %>
		<%@ include file="/WEB-INF/jsp/secure/common/plainHeader.jsp" %>
	<%}%>

	</TD><!-- *****************Header End***************** -->
</TR>
<TR>
	<TD width="100%" valign="top">

		<decorator:body />



			<br/>
	</td>
</tr>

<tr>
<td colspan="3" width="100%" align="center">
<%	if (request.getRequestURI().indexOf("public/") >= 0 ){ %>
		<%@ include file="/WEB-INF/jsp/public/common/footer.jsp" %>

	<%  } else if (request.getRequestURI().indexOf("secure/") >= 0) {%>
		<%@ include file="/WEB-INF/jsp/secure/common/footer.jsp" %>
	<%}%>
</td>
</tr>

</table>
</body>
</html>

