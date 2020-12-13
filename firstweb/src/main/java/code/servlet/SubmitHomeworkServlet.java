package code.servlet;

import code.jdbc.StudentHomeworkJDBC;
import code.model.Homework;
import code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit")
public class SubmitHomeworkServlet extends HttpServlet {
    /**
     * get请求用来展示作业详细信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Homework homework = StudentHomeworkJDBC.showHomeworkDetails(id);//访问数据库
        req.setAttribute("homework",homework);
        req.getRequestDispatcher("submitHomework.jsp").forward(req,resp); //展示内容
    }


    /**
     *post请求用来提交作业，记录到数据库中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        StudentHomework studentHomework = new StudentHomework();

        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));

        boolean result = StudentHomeworkJDBC.addStudentHomework(studentHomework);

        req.setAttribute("isOK", result);   //判断是否提交成功
        req.setAttribute("type","addStudentHomework");
        req.getRequestDispatcher("check.jsp").forward(req,resp);
    }
}
