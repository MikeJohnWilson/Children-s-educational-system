<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowAnswer.jsp' starting page</title>
    
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
        <h1>显示正确答案页面</h1>
        <table border="1">
            <tr>
                <td>题目</td>
                <td><s:property value="questions.getQuestionName()"/></td>
            </tr>
            <tr>
                <td>正确答案描述</td>
                <td><s:property value="questions.getQuestionRightDescription()"/></td>
            </tr>
             <tr>
                <td>用户答案描述</td>
                <td><s:property value="questions.getQuestionUserDescription()"/></td>
            </tr>
             <tr>
                <td>结果</td>
                <td><s:property value="questions.getQuestionIsRight()"/></td>
            </tr>
        </table>
  </body>
</html>
