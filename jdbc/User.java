package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class User {
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Boolean emailVerified;
  private Boolean isDeleted;
  private Boolean isSuspended;
  private Date createdAt;
  private Date updatedAt;

  public User() {
  }

  public User(String firstName, String lastName, String email, String id) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setEmailVerified(Boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public Boolean getEmailVerified() {
    return emailVerified;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setIsSuspended(Boolean isSuspended) {
    this.isSuspended = isSuspended;
  }

  public Boolean getIsSuspended() {
    return isSuspended;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String toString() {
    return "User{" + "\"email:\" " + email + ", \"firstName\" " + firstName + "}";
  }

  public static List<User> fetchAllUsers(Connection conn, int page, int limit) throws SQLException {
    String sql = "SELECT * FROM users ORDER BY created_at DESC LIMIT ? OFFSET ?;";
    int offset = page * limit - limit;

    User user = new User();

    List<User> users = new ArrayList<>();

    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setInt(1, page);
    preparedStatement.setInt(2, offset);

    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
      user.setId(resultSet.getString("id"));
      user.setFirstName(resultSet.getString("first_name"));
      user.setLastName(resultSet.getString("last_name"));
      user.setLastName(resultSet.getString("last_name"));
      user.setEmail(resultSet.getString("email"));
      user.setEmailVerified(resultSet.getBoolean("email_verified"));
      user.setPassword(resultSet.getString("password"));
      user.setCreatedAt(resultSet.getDate("created_at"));
      user.setUpdatedAt(resultSet.getDate("updated_at"));
      user.setIsDeleted(resultSet.getBoolean("is_deleted"));
      user.setIsSuspended(resultSet.getBoolean("is_suspended"));
      users.add(user);

    }

    return users;
  }

  public static Optional<User> selectById(Connection conn, String id) throws SQLException {
    String sql = "SELECT id FROM users WHERE id = ?;";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, id);
    ResultSet resultSet = stmt.executeQuery();

    User user = new User();

    while (resultSet.next()) {

      user.setId(resultSet.getString("id"));
      return Optional.of(user);
    }
    return Optional.empty();
  }
}
