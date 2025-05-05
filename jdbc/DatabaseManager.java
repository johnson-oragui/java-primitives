package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
  public static Connection useConnection(Connection conn) throws SQLException, ClassNotFoundException {
    return conn;
  }

}
