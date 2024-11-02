package algorithm.collection.common.util;

import algorithm.collection.common.datastruct.tag.QuestionTag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2024-10-27 20:42
 **/
public class SchedulePlanExcutor {

    public static void main(String[] args) throws SQLException {
        createTable();
        insertRecord();
    }

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (id, name, email, country, password) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String createTableSQL = "create table users (\r\n" + "  id  int(3) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
            "  password varchar(20)\r\n" + "  );";

    public static void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Tony");
            preparedStatement.setString(3, "tony@gmail.com");
            preparedStatement.setString(4, "US");
            preparedStatement.setString(5, "secret");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            //H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // 创建连接到本地文件数据库，如果不存在则会自动创建
            conn = DriverManager.getConnection("jdbc:h2:./data/sample");

            // 执行数据库操作
            // 在这里您可以创建表、插入数据等

            System.out.println("本地文件数据库已创建成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            //H2JDBCUtils.printSQLException(e);
        }
    }


    public void registerItem_10_25(String item) {
        List<QuestionTag> items = new ArrayList<>();
        //QuestionTag questionTag = new QuestionTag();
        items.add(null);
    }

    public void registerItem_10_26(String item) {
        List<String> items = List.of("");
    }

}
