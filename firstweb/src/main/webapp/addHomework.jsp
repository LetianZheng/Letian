<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新作业</title>
</head>
<body>
<div align="center">
    <h2>新作业</h2>
    <form action="${pageContext.request.contextPath}/addHomework" method="post">
        <table style="line-height: 40px">
            <tr>
                <th>作业标题:</th>
                <td><input type="text" name="title" maxlength="20" size="40" style="font-family: arial" required></td>
            </tr>
            <tr>
                <th>作业内容:</th>
                <td><textarea name="content" rows="10" cols="42" style="font-family: arial" required></textarea></td>
            </tr>

            <tr align="center">
                <th><input type="reset" value="清空"></th>
                <td><input type="submit" value="提交"> </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
