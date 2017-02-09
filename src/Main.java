import java.sql.*;

/**
 * Created by vig on 1/13/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String jdbcDriverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/vasya?useSSL=false";

        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement stmt = null;
        //1
        Class.forName(jdbcDriverName);

        //2
        conn = DriverManager.getConnection(connectionString, "root", "honor3");

        //3
        /*stmt = conn.createStatement();
        String query = "select * from vasya.account";*/
        String idQ = "1";
        String query = "select * from vasya.account" +
                " where id = ?";
        stmt = conn.prepareStatement(query);
        stmt.setObject(1,idQ);


        stmt.execute(query);

        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString("name");
            int age = rs.getInt(3);
            System.out.println(name + " " + id + " " + age);
        }
        conn.close();
    }
}
