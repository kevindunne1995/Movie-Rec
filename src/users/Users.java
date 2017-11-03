package users;

public class Users {
	private String UserID;
	private String UserFName;
	private String UserLName;
	private String Age;
	private String Gender;
	private String Occupation;
	private String num;

	public Users() {
		this.UserID = "";
		this.UserFName = "";
		this.UserLName = "";
		this.Age = "";
		this.Gender = "";
		this.Occupation = "";
		this.num = "";

	}

	public Users(String UserID, String UserFName, String UserLName, String Age ,String Gender,String Occupation, String num) {
		this.UserID = UserID;
		this.UserFName = UserFName;
		this.UserLName = UserLName;
		this.Age = Age;
		this.Gender = Gender;
		this.Occupation = Occupation;
		this.num = num;

	}

	public String getUserId() {
		return UserID;
	}
	
	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", UserFName=" + UserFName + ", UserLName=" + UserLName + ", Age=" + Age
				+ ",Gender=" +Gender +", Occupation=" + Occupation +",num=" + num +" ]";
	}

}


