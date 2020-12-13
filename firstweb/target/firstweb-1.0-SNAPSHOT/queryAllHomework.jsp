<%@ page import="code.model.Homework" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询作业</title>
    <%--    将指定的作业id传给/submit,以便提交作业--%>
    <script>
        function show(id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",id)
            let sub = document.getElementById('sub')
            sub.submit()
        }
    </script>
</head>
<body>


<form id="sub" method="get" action="${pageContext.request.contextPath}/submit">
    <input id="homeworkId" name="id" type="hidden">
    <table align="center" width="960" border="1">
        <tr>
            <th>作业编号</th>
            <th>作业标题</th>
            <th>作业内容</th>
            <th>提交作业</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("list");
            if (list == null || list.size() <= 0){
//                out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td width="5%"><%=homework.getId()%></td>
            <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=homework.getTitle()%></td>
            <td width="65%" style="word-break: break-all;word-wrap: break-word"><%=homework.getContent()%></td>
            <td width="8%"><input type="button" width="100%" value="提交作业" onclick="show(<%=homework.getId()%>)"> </td>
        </tr>

        <%
                }
            }
        %>

    </table>
</form>
</body>
</html>