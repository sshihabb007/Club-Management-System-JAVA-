package Model;

public class User
{
	private String userName;
	private String password;
	private String type;
	private String clubName;
	private String email;
	private String phone;
	public void setUname(String a)
	{
		userName = a;
	}
	public void setPass(String a)
	{
		password = a;
	}
	public void setType(String a)
	{
		type = a;
	}
	public void setClubName(String a)
	{
		clubName = a;
	}
	public void setEmail(String a)
	{
		email = a;
	}
	public void setPhone(String a)
	{
		phone = a;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public String getType()
	{
		return type;
	}
	public String getClubName()
	{
		return clubName;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPhone()
	{
		return phone;
	}
}
