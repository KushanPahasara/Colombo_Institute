package Colombo;

public class Login {
 private String UserID;
 private String password;
 
 public Login() {
	// TODO Auto-generated constructor stub
	 
	 
}
 
 public Login(String UserID,String password) {
		this.UserID=UserID;
		this.password=password;
	}
 
 public void setUserID(String userID) {
	this.UserID = userID;
}
 
 public String getUserID() {
	return UserID;
}
 
 public void setPassword(String password) {
	this.password = password;
}
 
 public String getPassword() {
	return password;
}
 
}
