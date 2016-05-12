import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProposedProject extends Project
{
	String approvedProjectID;
	String projectReadinessElements;
	String projectSelection;
	String submissionType;
	String submissionDeadline;
	String workflowStatus;
	String projectID;
	
	ArrayList<String> proposedProject = new ArrayList<String>();
	
	/*Setters*/
	public void setApprovedProjectID(String approvedProjectID)
	{
		this.approvedProjectID = approvedProjectID;
	}
	
	public void setProjectReadinessElements(String projectReadinessElements)
	{
		this.projectReadinessElements = projectReadinessElements;
	}
	
	public void setProjectSelection(String projectSelection)
	{
		this.projectSelection = projectSelection;
	}
	
	public void setSubmissionType(String submissionType)
	{
		this.submissionType = submissionType;
	}
	
	public void setSubmissionDeadline(String submissionDeadline)
	{
		this.submissionDeadline = submissionDeadline;
	}
	
	public void setWorkflowStatus(String workflowStatus)
	{
		this.workflowStatus = workflowStatus;
	}
	
	public void setProjectID(String projectID)
	{
		this.projectID = projectID;
	}
	
	
	/*Getters*/
	public String getApprovedProjectID()
	{
		return approvedProjectID;
	}
	
	public String getProjectReadinessElements()
	{
		return projectReadinessElements;
	}
	
	public String getProjectSelection()
	{
		return projectSelection;
	}
	
	public String getSubmissionType()
	{
		return submissionType;
	}
	
	public String getSubmissionDeadline()
	{
		return submissionDeadline;
	}
	
	public String getWorkflowStatus()
	{
		return workflowStatus;
	}
	
	public String getProjectID()
	{
		return projectID;
	}
	
	
	public ArrayList<String> createProposedProject(String approvedProjectID, String projectReadinessElements, String projectSelection,
												String submissionType,String submissionDeadline,String workflowStatus,String projectID)
	{
		setApprovedProjectID(approvedProjectID);
		setProjectReadinessElements(projectReadinessElements);
		setProjectSelection(projectSelection);
		setSubmissionType(submissionType);
		setSubmissionDeadline(submissionDeadline);
		setWorkflowStatus(workflowStatus);
		setProjectID(projectID);
		
		String apID = getApprovedProjectID(); //0
		String pre = getProjectReadinessElements(); //1
		String ps = getProjectSelection(); //2
		String st = getSubmissionType(); //3
		String sd = getSubmissionDeadline(); //4
		String ws = getWorkflowStatus(); //5
		String pID = getProjectID(); //6
		
		proposedProject.add(apID);
		proposedProject.add(pre);
		proposedProject.add(ps);
		proposedProject.add(st);
		proposedProject.add(sd);
		proposedProject.add(ws);
		proposedProject.add(pID);
		
		return proposedProject;
	}
	
	public boolean storeProposedProject(ArrayList<String> proposedProject)
	{
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		String pid = "";
		Connection connection = null; 
		String sql = db.createProposedProjectQuery(proposedProject);
		boolean storeProject = false;
		
		try 
		{
			connection = connect.connectToDatabase();
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);


		}catch(SQLException se){
			se.printStackTrace();
		}
		
		if (pid.equals(proposedProject.get(6)))
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
	
	public boolean editProposedProject(String columnName, String newValue, String pID){
		
		DBConnection connect = new DBConnection();
		DatabaseManager db = new ProjectDB();
		Statement stmt = null;
		Connection conn = null; 
		boolean success = false;
		String sql = db.editProposedProjectQuery(columnName, newValue, pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				success = false;
				System.out.println("The proposed project WAS NOT updated");
				
			}

			else
			{
				success = true;
				System.out.println("The proposed project WAS updated SUCCESSFULLY");
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
		String sql = db.deleteProposedProjectQuery(pID);
		
		try 
		{
			conn = connect.connectToDatabase();
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 0)
			{
				deleteProject = false;
				System.out.println("The proposed project WAS NOT deleted");
				
			}

			else
			{
				deleteProject = true;
				System.out.println("The proposed project WAS deleted");
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
				
		return deleteProject;
	}

}
