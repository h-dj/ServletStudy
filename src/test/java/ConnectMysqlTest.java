import org.junit.Test;

import java.sql.*;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ConnectMysqlTest
 * @Package PACKAGE_NAME
 * @Description: 连接数据测试
 * @date 2018/3/22 12:16
 */
public class ConnectMysqlTest {


    @Test
    public void connectTest() {
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost/testdb";
        String dbUser = "root";
        final String passwd = "1234";
        try {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbURL, dbUser, passwd);
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("<br>" + rs.getString(1) + " " + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
