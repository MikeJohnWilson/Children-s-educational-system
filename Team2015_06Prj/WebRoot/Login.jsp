<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>登录界面. </h1>
     <s:actionerror/>
	<s:form action="LoginAction" namespace="/UserLoginAndRegisterNS">
		<s:textfield name="userLoginName" label="用户名"></s:textfield>
		<s:password name="userPassWorld" label="密码"></s:password>
		<s:submit value="登录" align="left" method ="Login"></s:submit>
	</s:form>
	<s:form action="ToUserRegisterPageAction" namespace="/UserLoginAndRegisterNS">
		<s:submit  value="注册" align="left" method="execute"></s:submit>
	</s:form>
</body>
</html>
