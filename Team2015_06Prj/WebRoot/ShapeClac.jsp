<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShapeClac.jsp' starting page</title>
    
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
    <h1>图形面价和周长问题.</h1> 
    
    <span>问题：<s:property value="questionName"/></span>
	<s:form action="SetOneQuestionAction" namespace="/DoQuestionNS">
	    
		<s:textfield name="area" label="面积"></s:textfield>
		<s:textfield name="perimeter" label="周长"></s:textfield>
		<s:submit value="提交" method="setAquestion"></s:submit>
	</s:form>
</body>
</html>
