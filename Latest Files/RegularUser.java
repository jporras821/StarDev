import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class RegularUser 
{

	public RegularUser()
	{

	}

	/* View Project */
	public void viewProject(String pID)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		String query = db.viewProject(pID);

		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) 
			{
				for (int i = 1; i <= columnsNumber; i++) 
				{
					if (i > 1);
					String columnValue = rs.getString(i);
					System.out.print(rsmd.getColumnName(i) + ": " + columnValue + "\n");
				}
			}
		}catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
