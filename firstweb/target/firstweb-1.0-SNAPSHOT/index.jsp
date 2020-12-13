<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/3/13
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>作业管理系统</title>
</head>
<body>
<h1 style="text-align:center">作业管理系统</h1>
<div style="margin-left: 300px">
  <ul style="line-height: 50px">
    <h2>教师</h2>
    <li><a href="addHomework.jsp">发布作业</a></li>
    <li><a href="addStudent.jsp">添加学生</a></li>
    <li><a href="${pageContext.request.contextPath}/showHomework">查看作业</a></li>
    <h2>学生</h2>
    <li><a href="${pageContext.request.contextPath}/allHomework">提交作业</a></li>
  </ul>
</div>

</body>
</html>
