<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<%
    String type = (String)request.getAttribute("type");
    boolean isOK = (boolean)request.getAttribute("isOK");
    if (type.equals("addHomework")){

        if (isOK){
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px; color: blue"><%="添加成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px;color: red"><%="添加失败!"%></p>

<%
    }
}else if (type.equals("addStudent")){
    if (isOK){
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px; color: blue"><%="添加成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px;color: red"><%="已有学生信息!无法添加！"%></p>

<%
    }
}else if (type.equals("addStudentHomework")){
    if (isOK){
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px; color: blue"><%="提交成功!"%></p>

<%
}else {
%>

<p style="margin: 50px; font-family: Arial; font-size: 50px; color: red"><%="提交失败!"%></p>

<%
        }
    }
%>
<a href="index.jsp" style="margin: 65px">确认</a>
</body>
</html>
