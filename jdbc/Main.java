package jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class Main {
  public static void main(String[] args) throws Exception {
    @SuppressWarnings("unused")
    Connection poolConn = DatabasePool.getConnection();
    // @SuppressWarnings("unused")
    Connection connection = DatabaseSinglePool.getConnection();
    Connection conn = DatabaseManager.useConnection(connection);

    List<User> user = User.fetchAllUsers(conn, 10, 1);
    System.out.println(user.toString());

    Optional<User> _user = User.selectById(conn, "019482e2-9477-7692-987e-08d88983be2e");
    if (_user.isPresent()) {
      System.out.println(_user.get().getId());
    } else {
      System.out.println("User not found");
    }
    conn.close();

  }
}
