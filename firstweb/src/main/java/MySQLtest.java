import java.sql.*;

import static com.mysql.cj.conf.PropertyKey.allowPublicKeyRetrieval;

public class MySQLtest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        String url = "jdbc:mysql://127.0.0.1:3306/sys?&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "Zhengletian123";

        String sql = "SELECT MatchID, OpponentID, Outcome FROM matches";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {

                    while (resultSet.next()) {
                        int matchId = resultSet.getInt(1);
                        String opponentId = resultSet.getString(2);
                        String outcome = resultSet.getString(3);
                        System.out.println("Match ID: " + matchId + "\t\t" + "Opponent ID: " + opponentId + "\t\t" + "Outcome: " + outcome);
                    }

                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}