<%@ page import="code.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业提交详细信息</title>
</head>
<body>
<h2 align="center" style="margin: 50px">作业详细内容</h2>
<table align="center" width="960" border="1">

    <tr bgcolor="">
        <th width="10%">学号</th>
        <th width="10%">作业编号</th>
        <th width="20%">作业标题</th>
        <th width="40%">作业内容</th>
    </tr>
    <%
        List<StudentHomework> list = (List<StudentHomework>)request.getAttribute("list");

        if (list == null || list.size() <= 0){

        }else {
            for (StudentHomework sh : list) {
    %>
    <tr>
        <td width="10%"><%=sh.getStudentId()%></td>
        <td width="10%"><%=sh.getHomeworkId()%></td>
        <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=sh.getHomeworkTitle()%></td>
        <td width="40%" style="word-break: break-all;word-wrap: break-word"><%=sh.getHomeworkContent()%></td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>

