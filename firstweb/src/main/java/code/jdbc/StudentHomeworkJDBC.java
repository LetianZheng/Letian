package code.jdbc;

import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJDBC {
    private static String url = "jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC";

    private static String driverName = "com.mysql.cj.jdbc.Driver";


    /**
     * 从s_student_homework表读取指定作业id 的所有记录，即某次作业的所有提交记录
     * @param id 指定的作业id
     * @return 返回结果list
     */
    public static List<StudentHomework> selectAll(String id) {

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + id;

        List<StudentHomework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }


    /**
     * 向s_homework添加作业记录
     * @param homework  将要添加的homework
     * @return true/false
     */
    public static boolean addHomework(Homework homework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into s_homework (title,content) values(?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,homework.getTitle());
                ps.setString(2,homework.getContent());
                resultSet = ps.executeUpdate(); //指示受影响的行数

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     * 向s_student添加学生
     * @param student 将要添加的student
     * @return true/false
     */
    public static boolean addStudent(Student student){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into s_student (id,name) values(?,?)";

        int resultSet = 0;
        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,student.getId());
                ps.setString(2,student.getName());
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     *从s_homework读取所有作业记录
     * @return  list
     */
    public static List<Homework> showHomework(){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM s_homework";

        List<Homework> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Homework homework = new Homework();
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    /**
     * 从s_homework表读取指定id的作业详细内容
     * @param id 作业id
     * @return 作业homework
     */
    public static Homework showHomeworkDetails(String id){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "SELECT * FROM s_homework WHERE id=" + id;

        Homework homework = new Homework();
        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return homework;
    }

    /**
     * 向s_student_homework表提交作业
     * @param studentHomework 作业
     * @return true/false
     */
    public static boolean addStudentHomework(StudentHomework studentHomework){

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sqlString = "insert into s_student_homework (student_id,homework_id," +
                "homework_title,homework_content) values(?,?,?,?)";

        int resultSet = 0;

        try (Connection connection = DriverManager.getConnection(url, "root", "Zhengletian123")) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,studentHomework.getStudentId());
                ps.setLong(2,studentHomework.getHomeworkId());
                ps.setString(3,studentHomework.getHomeworkTitle());
                ps.setString(4,studentHomework.getHomeworkContent());
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }
}
