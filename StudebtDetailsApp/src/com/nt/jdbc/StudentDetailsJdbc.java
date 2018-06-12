package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetailsJdbc {
	private static final String Insert_query="INSERT INTO STUDENT VALUES(?,?,?)";
	public static void main(String[] args) {
		Scanner scn=null;
		String name=null,address=null;
		int no=0;
		Connection con=null;
		PreparedStatement ps=null;
		int rs=0;
		
		try {
			//read input data
			scn=new Scanner(System.in);
			if(scn!=null) {
				System.out.println("Enter student no");
			    no=scn.nextInt();
			    System.out.println("Enter student name");
			    name=scn.next();
			    System.out.println("Enter student address");
			    address=scn.next();
			}
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create preparedstatement
		    if(con!=null)
		    	ps=con.prepareStatement(Insert_query);
			//set values
			ps.setInt(1,1007);
			ps.setString(2,"muni");
			ps.setString(3,"ctc");
			//create result set and executequery
		    rs=ps.executeUpdate();
		    //process the resultset
		    if(rs==0) {
		    	System.out.println("fail to insert record");
		    }
		    else {
		    	System.out.println("sucessfully insert record");
		    }
		    
			
					
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			
		}
		catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}

}
