package myProject;

public class AdminC {
	String adminkey;
	public AdminC(String adminkey) 
	{
		this.adminkey=adminkey;
	}
	public static String sql()
	{
		return "select *from admin;";
	}
}
