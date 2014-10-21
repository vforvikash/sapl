<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<div style="auto" xmlns="http://www.w3.org/1999/xhtml">
	<div style="float:left;">
		<a href="/sapl/"><img width="202" height="73" border="0" src="<c:url value="/images/logo.gif" />">
		</a>
	</div>
	<div style="margin-left:96%;">
	<br/>
	<sec:authorize access="isAuthenticated()"><sec:authentication property="principal.username" /> is working.</sec:authorize>
	<a href="<c:url value="/j_spring_security_logout" />" style="color:black;" title="Logout"> <INPUT TYPE="image" SRC="/sapl/images/logout.png"/></a></div>
	<br style="clear:both;">
	<br style="line-height:10px;">
</div>


