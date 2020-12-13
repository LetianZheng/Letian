<%@ page import="code.model.Homework" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看作业</title>

    <%--    将作业id传到/query--%>
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
<form id="sub" method="get" action="${pageContext.request.contextPath}/query">
    <input id="homeworkId" name="id" type="hidden">
    <table align="center" width="960" border="1">
        <tr>
            <th width="10%">作业编号</th>
            <th width="80%" style="word-break: break-all;word-wrap: break-word">作业标题</th>
            <th width="10%">详细信息</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("list");
            if (list == null || list.size() <= 0){
//                out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td><%=homework.getId()%></td>
            <td><%=homework.getTitle()%></td>
            <td><input type="button" value="详细信息" onclick="show(<%=homework.getId()%>)"> </td>
        </tr>

        <%
                }
            }
        %>

    </table>
</form>
</body>
</html>
