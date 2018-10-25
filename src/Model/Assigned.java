package Model;

public class Assigned 
{
	private String eventId;
	private String fristName;
	private String lastName;
	private String userName;
	public void setEvent(String e)
	{
		eventId = e;
	}
	public void setFname(String a)
	{
		fristName = a;
	}
	public void setLname(String a)
	{
		lastName = a;
	}
	public void setUname(String a)
	{
		userName = a;
	}
	public String getEventId()
	{
		return eventId;
	}
	public String getFirstName()
	{
		return fristName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getUserName()
	{
		return userName;
	}
}
