import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubmittedProject extends Project
{
	ArrayList<String> submittedProject = new ArrayList<String>();
	
	String tpbApproval;
	String federalApproval;
	String stateApproval;
	String submissionStatus;
	String projectID;
	
	public void setTPBApproval(String tpbApproval)
	{
		this.tpbApproval = tpbApproval;
	}
	
	public void setFederalApproval(String federalApproval)
	{
		this.federalApproval = federalApproval;
	}
	
	public void setStateApproval(String stateApproval)
	{
		this.stateApproval = stateApproval;
	}
	
	public void setSubmissionStatus(String submissionStatus)
	{
		this.submissionStatus = submissionStatus;
	}
	
	public void setProjectID(String projectID)
	{
		this.projectID = projectID;
	}
	
	
	
	// Getters
	public String getTPBApproval()
	{
		return tpbApproval;
	}
	
	public String getFederalApproval()
	{
		return federalApproval;
	}
	
	public String getStateApproval()
	{
		return stateApproval;
	}
	
	public String getSubmissionStatus()
	{
		return submissionStatus;
	}
	
	public String getProjectID()
	{
		return projectID;
	}
	
	public ArrayList<String> createSubmittedProject(String tpbApproval,String federalApproval,String stateApproval,
													String submissionStatus,String projectID)
	{
		setTPBApproval(tpbApproval);
		setFederalApproval(federalApproval);
		setStateApproval(stateApproval);
		setSubmissionStatus(submissionStatus);
		setProjectID(projectID);
		
		String tpb = getTPBApproval();
		String fa = getFederalApproval();
		String sa = getStateApproval();
		String ss = getSubmissionStatus();
		String pid = getProjectID();
		
		submittedProject.add(tpb); //0
		submittedProject.add(fa); //1
		submittedProject.add(sa); //2
		submittedProject.add(ss); //3
		submittedProject.add(pid); //4
		
		return submittedProject;
	}
	
	public boolean storeProjectSubmission(ArrayList<String> submittedProject)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		String pid = "";
		Connection connection = null; 
		String sql = db.createSubmittedProjectQuery(submittedProject);
		boolean storeProject = false;
		
		try 
		{
			connection = connect.connectToDatabase();
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);


		}catch(SQLException se){
			se.printStackTrace();
		}
		
		if (pid.equals(submittedProject.get(4)))
		{
			storeProject = true;
			System.out.println("This project ID# already exists");
			
		}

		else
		{
			storeProject = false;
			System.out.println("Submitted project values were stored successfully!");
		}
		
		return storeProject;
	}
	
	public boolean editSubmittedProject(String columnName, String newValue, String pID){
		
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		boolean success = false;
		String sql = db.editSubmittedProjectQuery(columnName, newValue, pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				success = false;
				System.out.println("The Submitted project WAS NOT updated");
				
			}

			else
			{
				success = true;
				System.out.println("The submitted project WAS updated SUCCESSFULLY");
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		
		return success;
	}
	
	public boolean deleteProject(String pID)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		boolean deleteProject = false;
		String sql = db.deleteSubmittedProjectQuery(pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				deleteProject = false;
				System.out.println("The submitted project WAS NOT deleted");
				
			}

			else
			{
				deleteProject = true;
				System.out.println("The submitted project WAS deleted");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
				
		return deleteProject;
	}
}
