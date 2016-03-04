<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'QuestionTypeList.jsp' starting page</title>
    
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
    <h1>作业练习页面 -<s:property value="userId"/>	,请选择作业练习</h1>
	<table>
	   <tr>
	       <th align="center">选择题目类型</th>
	       <td> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </td>
	       <th align="center">我已经做过的题目类型</th>
	   </tr>
	   
	   <tr>
	       <td>
	           <table align="center">
	               <s:iterator value="questionAllTypeList">
	                   <tr>
	                       <td>
	                           <s:property value="Id"/>
							</td>
	                       <td>                        	                                                     	                           
	                            <a href='<s:url action="GetOneQuestionAction" namespace = "/DoQuestionNS"><s:param name="questionType" value="Id" /></s:url>'><s:property value="QuestionTypeName"/></a> 
	                       </td>                      
	                   </tr>
	               </s:iterator>
	           </table>
			</td>
			
			 <td> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </td>
           
			<td>
			     <table align="center">			
			         <tr><a href='<s:url action="ShowAnswerListAction" namespace = "/ShowQuestionNS"></s:url>'>共做:<s:property value="userDidNum"/>个</a></tr>
			         <s:iterator value="questionUserTypeList">
			             <tr>
			                 <td>
                               <s:property value="Id"/>、
                             </td>
			                 <td>
			                     <a><s:property value="QuestionTypeName"/></a>
							</td>
			             </tr>
			         </s:iterator>
			     </table>
               
            </td>
	   </tr>
	</table>
  </body>
</html>
