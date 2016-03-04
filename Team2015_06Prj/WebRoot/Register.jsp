<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
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
    <h1>注册界面.</h1> 
     <s:actionerror/>
    <s:form action="RegisterAction" namespace="/UserLoginAndRegisterNS">               
        <s:textfield name="userLoginName" label="用户名"></s:textfield>                                               
        <s:textfield name="userPassWorld" label="密码"></s:textfield>  
        <s:textfield name="repetitionPassWorld" label="重复密码"></s:textfield>  
        <s:submit value="注册" align="right" method="Register"/>             
    </s:form>
</body>
</html>
