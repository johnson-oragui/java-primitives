package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSinglePool {
  public static Connection connection;

  public static Connection getConnection() throws SQLException, ClassNotFoundException {
    // Connection conn = null;

    Class.forName("org.postgresql.Driver");
    connection = DriverManager.getConnection(MyConfig.DB_URL, MyConfig.DB_USER, MyConfig.DB_PASSWORD);

    if (connection != null) {
      System.out.println("Connected to the PostgreSQL database!");
    } else {
      System.out.println("Failed to make connection!");
    }
    return connection;
  }

  public static void closeDataSource() throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }

  }
}
