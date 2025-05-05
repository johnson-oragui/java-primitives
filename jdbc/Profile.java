package jdbc;

public class Profile {
  private String id;
  private String userId;

  public Profile() {
  }

  public Profile(String id, String userId) {
    this.id = id;
    this.userId = userId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }
}