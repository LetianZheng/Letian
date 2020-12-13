package code.servlet;

import code.jdbc.StudentHomeworkJDBC;
import code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showHomework")
public class ShowHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Homework> list = StudentHomeworkJDBC.showHomework();

        req.setAttribute("list",list);

        req.getRequestDispatcher("queryStudentHomework.jsp").forward(req,resp);
    }
}
