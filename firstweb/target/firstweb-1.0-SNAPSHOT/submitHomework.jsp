<%@ page import="code.model.Homework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<h2 align="center" style="margin: 50px">提交作业</h2>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/submit">
        <table border="1" width="960">
            <%
                Homework homework = (Homework) request.getAttribute("homework");

            %>
            <tr>
                <th width="30%">作业标题:</th>
                <td width="70%"><%=homework.getTitle()%></td>
            </tr>
            <tr>
                <th width="30%">作业内容:</th>
                <td width="70%"><%=homework.getContent()%></td>
            </tr>
            <tr>
                <th width="30%">学号:</th>
                <td width="70%"><input type="number" name="studentId"
                                       maxlength="20" style="font-family: Arial;  width: 100%" required>
                </td>
            </tr>
            <input type="hidden" name="title" value="<%=homework.getTitle()%>">
            <input type="hidden" name="homeworkId" value="<%=homework.getId()%>">
            <tr>
                <th width="30%">作业内容</th>
                <td width="70%"><textarea name="content"  style="font-family: Arial; width: 100%" rows="10" required></textarea></td>
            </tr>
            <tr style="border: none">
                <td align="center"><input type="reset" value="清空"></td>
                <td align="center"><input type="submit" value="提交"></td>
            </tr>
        </table
    </form>
    <li><a href="index.jsp">返回</a></li>
</div>
</body>
</html>
