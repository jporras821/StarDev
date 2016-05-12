
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

public class AuthenticatedUser extends RegularUser 
{

	LinkedHashMap <String, Object> authenticatedUserInfo = new LinkedHashMap <String, Object>();
	String username;
	String password;
	String firstname;
	String lastname;
	String dob;
	String accountType;
	String accountID; 
	String creationDate;
	String requestDate; 
	String phoneNumber;
	String email;
	boolean isApproved;

	
	public AuthenticatedUser(String username, String password, String firstname, String lastname, String dob,
			String accountType, String accountID, String creationDate, String requestDate, String phoneNumber,
			String email, boolean isApproved) {
//		authenticatedUserInfo.put("username", username);
//		authenticatedUserInfo.put("password", password);
//		authenticatedUserInfo.put("firstname", firstname);
//		authenticatedUserInfo.put("lastname", lastname);
//		authenticatedUserInfo.put("dob", dob);
//		authenticatedUserInfo.put("accountType", accountType);
//		authenticatedUserInfo.put("accountID", accountID);
//		authenticatedUserInfo.put("creationDate", creationDate);
//		authenticatedUserInfo.put("requestDate", requestDate);
//		authenticatedUserInfo.put("phoneNumber", phoneNumber);
//		authenticatedUserInfo.put("email", email);
//		authenticatedUserInfo.put("isApproved", isApproved);
		this.username = username;
		this.password = password;
		this.firstname  = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.accountType = accountType;
		this.accountID  = accountID;
		this.creationDate = creationDate;
		this.requestDate = requestDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isApproved = isApproved;
	}
	
	public AuthenticatedUser()
	{
		
	}

	/* Authenticates User */
	public boolean authenticateUser(String username, String password)
	{
		boolean authenticated = false;
		DBConnection connect = new DBConnection();
		DatabaseManager db = new UserDB();
		Statement stmt = null;
		Connection conn = null; 
		String pass = ""; /*Password retrieved from db*/
		String sql = db.authenticateUserQuery(username);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				pass = rs.getString("password");
			}

		}catch(SQLException se){
			se.printStackTrace();
		}
		if (pass.equals(password))
		{
			authenticated = true;
		}
		
		return authenticated;
	}
	

	public LinkedHashMap<String, Object> getAuthenticatedUserInfo() {
		return authenticatedUserInfo;
	}

	public void setAuthenticatedUserInfo(LinkedHashMap<String, Object> accountElements) {
		this.authenticatedUserInfo = authenticatedUserInfo;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApprove(boolean isApprove) {
		this.isApproved = isApprove;
	}
}
