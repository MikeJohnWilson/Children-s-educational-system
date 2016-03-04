<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowAnswerList.jsp' starting page</title>
    
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
    <h1>答案列表</h1>
    <table border="1">
		<s:iterator value="showQuestionList"><tr>
		  <td><s:property value="Id"/></td>
		  <td>
		      <table border="1">
		          <tr>
		              <td>题目</td>
		              <td style="width:600px"><s:property value="QuestionName"/></td>
		          </tr>
		           <tr>
                      <td>正确答案</td>
                      <td style="width:600px"><s:property value="QuestionRightDescription"/></td>
                  </tr>
                   <tr>
                      <td>您的答案</td>
                      <td style="width:600px"><s:property value="QuestionUserDescription"/></td>
                  </tr>
                   <tr>
                      <td>回答情况</td>
                      <td style="width:600px"><s:property value="QuestionIsRight"/></td>
                  </tr>
		      </table>
		  </td>
		</tr></s:iterator>
	</table>
	<a href='<s:url action="BeforePageAction" namespace = "/ShowQuestionNS"></s:url>'>上一页</a>
    <a href='<s:url action="NextPageAction" namespace = "/ShowQuestionNS"></s:url>'>下一页</a>
</body>
</html>
