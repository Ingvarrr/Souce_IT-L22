import ClassesFromMySQL_DB.Account;
import ClassesFromMySQL_DB.Class1;
import ClassesFromMySQL_DB.School;
import ClassesFromMySQL_DB.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vig on 2/8/17.
 */
public class Main {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/vasya?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "honor3";

    public static void main(String[] args) {
        try {
            selectAccountsFromTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectAccountsFromTable() throws SQLException{
        Connection connectionDB = null;
        PreparedStatement preparedStatement = null;
        HashMap<Long,Account> accounts = new HashMap<>();

        String sqlQuery = "SELECT acc.*,class.room_number,class.id\n" +
                "FROM vasya.account AS acc\n" +
                "INNER JOIN vasya.class AS class ON class.number = acc.class_number";
        String sqlQuery2 = "SELECT sc.*,ats.account_id\n" +
                "FROM vasya.school AS sc\n" +
                "INNER JOIN vasya.account_to_schoolNumber AS ats ON ats.school_number = sc.number";
        String sqlQuery3 = "SELECT acc.id, sb.*\n" +
                "FROM vasya.account AS acc\n" +
                "INNER JOIN vasya.account_to_subject AS ats ON ats.account_id = acc.id\n" +
                "INNER JOIN vasya.subject AS sb ON sb.id = ats.subject_id";
        try {
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connectionDB = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (connectionDB != null) {
                preparedStatement = connectionDB.prepareStatement(sqlQuery);
//                preparedStatement.setInt(1, 1);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    Long id = rs.getLong(1);
                    String name = rs.getString("name");
                    Byte age = rs.getByte(3);
                    Long classId = rs.getLong(6);
                    Integer roomNumber = rs.getInt(5);
                    String classNumber = rs.getString(4);
                    Class1 class1 = new Class1(classId,roomNumber,classNumber);
                    List<Subject> list = new ArrayList<>();
                    Account account = new Account(id, name, age, class1, null, list);
                    accounts.put(id, account);
                    System.out.println(id + name + age + classId + roomNumber + classNumber);
                }
            }
            if (connectionDB != null){
                preparedStatement = connectionDB.prepareStatement(sqlQuery2);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    Long id = rs.getLong(1);
                    String address = rs.getString("adress");
                    Integer number = rs.getInt(3);
                    Byte floors = rs.getByte(4);
                    String speciality = rs.getString("speciality");
                    Long accountId = rs.getLong(6);
                    if (accounts.containsKey(accountId)) {
                        School school = new School(id, address, number, floors, speciality);
                        accounts.get(accountId).setSchool(school);
                    }
                }
            }
            if (connectionDB != null){
                preparedStatement = connectionDB.prepareStatement(sqlQuery3);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    Long accountId = rs.getLong(1);
                    Long id = rs.getLong(2);
                    String name = rs.getString("name");
                    Integer roomNumber = rs.getInt(4);
                    if (accounts.containsKey(accountId)) {
                        Subject subject = new Subject(id, name, roomNumber);
                        accounts.get(accountId).getSubjects().add(subject);
                    }
                }
            }
            System.out.println(accounts.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connectionDB != null){
                connectionDB.close();
            }
        }

    }
}
