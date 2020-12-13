package code.servlet;

import code.jdbc.StudentHomeworkJDBC;
import code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query")
public class QueryStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<StudentHomework> list = StudentHomeworkJDBC.selectAll(id);//访问数据库
        req.setAttribute("list",list);
        req.getRequestDispatcher("homeworkSubmission.jsp").forward(req,resp); //展示数据
    }
}
