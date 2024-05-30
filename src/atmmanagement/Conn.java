package atmmanagement;

import java.sql.*;

public class Conn 
{
	Connection c;
	Statement s;
	
	public Conn()
	{
		
		try
		{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem", "root", "sysroot");
			s = c.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
