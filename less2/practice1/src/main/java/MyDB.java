/**
 * Created by Artyom Karnov on 8/18/16.
 * artyom-karnov@yandex.ru
 **/

import java.sql.*;

public class MyDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";

    static final String USER = "root";
    static final String PASS = "214189";

    public static void main(String[] args) throws SQLException {
        MyDB myDB = new MyDB();
        System.out.println("Not prepared");
        myDB.getTicketNotPrepared("Artyom");
        System.out.println("Prepared");
        myDB.getTicketPrepared("Artyom");
    }

    public void getTicketNotPrepared(String userName) throws SQLException {
        try {
            Connection newCon = null;
            newCon = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement newState = null;
            newState = newCon.createStatement();

            String sql = "SELECT *\n" +
                    "FROM Passanger\n" +
                    "  INNER JOIN Ticket ON Passanger.id = Ticket.passange\n" +
                    "WHERE name = '" + userName + "'";
            ResultSet rs1 = newState.executeQuery(sql);
            while (rs1.next()) {
                int id = rs1.getInt("id");
                String date = rs1.getString("date");
                int passagers = rs1.getInt("passange");
                int train = rs1.getInt("train");
                System.out.println("id: " + id + " date " + date + " passanger " + passagers + " train " + train);
            }
            rs1.close();
            newState.close();
            newCon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getTicketPrepared(String userName) throws SQLException {
        String sql = "SELECT *\n" +
                "FROM Passanger\n" +
                "  INNER JOIN Ticket ON Passanger.id = Ticket.passange\n" +
                "WHERE name = '" + userName + "'";
        try {
            Connection newCon = null;
            newCon = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement newState = null;
            newState = newCon.prepareStatement(sql);

            ResultSet rs1 = newState.executeQuery(sql);
            while (rs1.next()) {
                int id = rs1.getInt("id");
                String date = rs1.getString("date");
                int passagers = rs1.getInt("passange");
                int train = rs1.getInt("train");
                System.out.println("id: " + id + " date " + date + " passanger " + passagers + " train " + train);
            }
            rs1.close();
            newState.close();
            newCon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

