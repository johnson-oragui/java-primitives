package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jdbc.MyConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePool {
  private static HikariDataSource dataSource;

  static {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(MyConfig.DB_URL);
    config.setUsername(MyConfig.DB_USER);
    config.setPassword(MyConfig.DB_PASSWORD);
    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    // Optional configurations
    config.setMaximumPoolSize(10); // Maximum number of connections in the pool
    config.setIdleTimeout(30000); // Maximum idle time for connections (ms)
    config.setConnectionTimeout(5000); // Maximum time to wait for a connection (ms)

    dataSource = new HikariDataSource(config);

  }

  public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  public static void closeDataSource() throws SQLException {
    if (dataSource != null && !dataSource.isClosed()) {
      dataSource.close();
    }
  }
}
