<%@ include file="/WEB-INF/jsp/secure/common/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAPL construction</title>
<script type="text/javascript">
function forgotPassword()
{
	alert("Its not implemented yet!!!");

}

</script>
<style>
.errorblock {
color: #ff0000;
background-color: #ffEEEE;
border: 3px solid #ff0000;
padding: 8px;
margin: 16px;
}
</style>
<sec:authorize ifAllGranted="ROLE_ADMIN">
      <!--redirect to home page-->
      <input type="hidden" name="userType" value="admin">
      <script language="javascript">
		window.location="<c:url value="/secure/admin/home.htm"/>";
	  </script>
</sec:authorize>
</head>
<body onload="document.j_spring_security_check.j_username.focus();">
<h1>Login here</h1>
<TABLE class="frmLogin" border="0">
		<TR><td>
		<form name="j_spring_security_check" action="<c:url value='j_spring_security_check'/>" method="POST">
			<table border="0">
			<tr>
				<td style="LETTER-SPACING: 1px;color: darkred; font-size:11px;">
					<b><font face=Arial,Helvetica size="-1">User:</font></b>
				</td>
				<td>
					
					<input tabindex=1 type='text' size="10" id='j_username' name='j_username' value='<sec:authentication property="name"/>'>
				</td>
				<td width="15px">&nbsp;</td>

				<td style="LETTER-SPACING: 1px;color: darkred; font-size:11px;">
					&nbsp;<b><font face=Arial,Helvetica size="-1">Password:</font></b>
				</td>
				<td>
					<input type='password' tabindex=2  id='j_password' name='j_password' size="10">
				</td>
				<td>
					<input type="image" src="images/login.jpg" width="48" height="19" alt="Login" tabindex="3">
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>

			<tr>
    		    <td colspan="3" align="left" class="t4">
            		<input type="checkbox" tabindex=4 class="noBorderLogin"  onclick="warning(this);" name="rememberMe" id="rememberMe" tabindex="3"/>
		            <spring:message code="index.rememberMe"/>
        		</td>
		    	<td colspan=3 align="left" >
			    	<A HREF="javascript:forgotPassword();" style="font-size:12px;color: blue;text-decoration:underline">Forget Password</A>
	          	</td>
		    </tr>
			</table>
		</form>

			</td>
		</TR>
	</TABLE>

	<!-- http://www.mkyong.com/spring-security/spring-security-form-login-example/ -->
	
	<%-- <h3>Properties obtained using &lt;sec:authentication /&gt; tag</h3>
	<table border="1">
		<tr>
			<th>Tag</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>&lt;sec:authentication property='name' /&gt;</td>
			<td><sec:authentication property="name"/>
			</td>
		</tr>
		<sec:authorize access="isAuthenticated()">
			<tr>
				<td>&lt;sec:authentication property='principal.username' /&gt;</td>
				<td><sec:authentication property="principal.username" />
				</td>
			</tr>
			<tr>
				<td>&lt;sec:authentication property='principal.enabled' /&gt;</td>
				<td><sec:authentication property="principal.enabled" />
				</td>
			</tr>
			<tr>
				<td>&lt;sec:authentication
					property='principal.accountNonLocked' /&gt;</td>
				<td><sec:authentication property="principal.accountNonLocked" />
				</td>
			</tr>
			<a href="<c:url value="/j_spring_security_logout" />" > Logoff</a>
		</sec:authorize>
	</table>
	<br/> --%>
	<script type="text/javascript">
		var userName='<sec:authentication property="name"/>';
		if(userName=='anonymousUser'){
			document.getElementById("j_username").value="";
		}
	</script>
	<c:if test="${not empty error}">
		<div class="errorblock">
		Login error : Please try again.<br />Root Cause: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<c:if test="${'fail' eq param.auth}">
        <div style="color:red">
                Login Failed!!!<br />
                Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
         </div>
    </c:if>
</body>
</html>