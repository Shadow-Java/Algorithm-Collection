package algorithm.collection.common.datastruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shadow
 * @create 2024-10-27 21:54
 **/
public class DemoApplicationTests {


    static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:./data/algorithm-collection.db");
        Statement statement = connection.createStatement();

        // 创建表
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        statement.execute(createTableQuery);

        // 插入数据
        String insertDataQuery = "INSERT INTO users (name) VALUES ('John Doe')";
        statement.execute(insertDataQuery);

        statement.close();
        connection.close();
    }

}
