package DAO;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/operator";

    static final String USER = "root";
    static final String PASS = "214189";

    static Connection conn;
    static Statement stmt;

    public JDBC() {
        conn = null;
        stmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");


            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTariffOtions(String tariffTitle) {
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT\n" +
                    "  Tariffs.title      AS tariff,\n" +
                    "  TariffOption.title AS tariffOption\n" +
                    "FROM Tariffs\n" +
                    "  INNER JOIN Tariffs_have_TariffOption ON Tariffs.id = Tariffs_have_TariffOption.Tariffs_id\n" +
                    "  INNER JOIN TariffOption ON Tariffs_have_TariffOption.TariffOption_id = TariffOption.id\n" +
                    "WHERE Tariffs.title = '" + tariffTitle + "'\n" +
                    "GROUP BY tariff, tariffOption";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String tariff = rs.getString("tariff");
                String tariffOption = rs.getString("tariffOption");
                System.out.println("tariff: " + tariff + ", tariffOption: " + tariffOption);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}