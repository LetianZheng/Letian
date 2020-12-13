package code.servlet;

import code.jdbc.StudentHomeworkJDBC;
import code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));

        boolean result = StudentHomeworkJDBC.addStudent(student);

        req.setAttribute("isOK", result);  //判断是否添加作业成功
        req.setAttribute("type","addStudent");
        req.getRequestDispatcher("check.jsp").forward(req,resp);
    }
}
