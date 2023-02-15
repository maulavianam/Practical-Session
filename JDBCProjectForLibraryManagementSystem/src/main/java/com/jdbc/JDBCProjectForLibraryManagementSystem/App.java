package com.jdbc.JDBCProjectForLibraryManagementSystem;

/**
 * Hello world!
 *
 */
/*public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App 
{
	static void Insertion()
	{
		System.out.println("Inserting Your Data");
		try
		{	
			//Establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			if(con.isClosed())
			{
				System.out.println("The connection is closed");
			}
			else
			{
				System.out.println("The connection is Established");
			}
			
			//Creating the Insert Statement
    		String sq = "insert into books (bid, bname, price) values(?,?,?)";
    		
			PreparedStatement pt = con.prepareCall(sq);
    		
    		//Insert Record Using Scanner
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter Book Id :- ");
    		int id = sc.nextInt();
    		System.out.println("Enter Book Name :- ");
    		String name = sc.next();
    		System.out.println("Enter Book Price :- ");
    		int price = sc.nextInt();
    		
    		pt.setInt(1,id);
    		pt.setString(2,name);
    		pt.setInt(3,price);
    		
    		//Executing the query
    		pt.executeUpdate();
    		System.out.println("The Data Is Inserted Successfully !");
    		
    		//Closing the connection
    		con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	static void Updation()
	{
		System.out.println("Updating Your Data");
		try
		{
			//Establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			if(con.isClosed())
			{
				System.out.println("The connection is closed");
			}
			else
			{
				System.out.println("The connection is Established");
			}
			
			//Creating the Update Statement
    		String sq = "update Books set bname = ? , price = ? where bid=?";
    		
			PreparedStatement pt = con.prepareCall(sq);
			
			//Insert Record that has to be updated Using Scanner
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the book name that you want to be changed :- ");
			String name = s.next();
			System.out.println("Enter the book prie that you want to be changed :- ");
			int price = s.nextInt();
			System.out.println("Enter the book id that you want to be changed :- ");
			int id = s.nextInt();
			
			pt.setString(1,name);
			pt.setInt(2, price);
			pt.setInt(3, id);
			
			//Executing the query
			pt.executeUpdate();
			System.out.println("The New Data Is Updated Successfully!");
			
			//Closing the connection
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	static void Deletion()
	{
		System.out.println("Delete Your Data");
		try
		{
			//Establishing the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			if(con.isClosed())
			{
				System.out.println("The connection is closed");
			}
			else
			{
				System.out.println("The connection is Established");
			}
			
			//Creating the Delete Statement
    		String sq = "delete from Books where bid = ?";
    		
			PreparedStatement pt = con.prepareCall(sq);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Book Id you want to delete :- ");
			int id = sc.nextInt();
			
			pt.setInt(1, id);
			
			//Executing the query
			pt.executeUpdate();
			System.out.println("The Data Is Deleted Successfully !");
			
			//Closing the connection
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	static void Display()
	{
		System.out.println("Displaying Your Data");
		try
    	{
			//Establish Connection To SQL
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library","root","root");
    		if(con.isClosed())
    		{
    			System.out.println("The connection is close");
    		}
    		else
    		{
    			System.out.println("The connection is Established");
    		}
    		//Select Statement
        	String q = "select bid, bname, price from Books";
        	PreparedStatement pt = con.prepareStatement(q);
        	ResultSet rset = pt.executeQuery();
        	
        	while(rset.next())
        	{
        		int id = rset.getInt(1);
        		String name = rset.getString(2);
        		int price = rset.getInt(3);
        	
        		
        		System.out.println("Book Id : "+id+" Book Name : "+name+" Book Price : "+price);
        	}
        	
        	//Closing the connection
    		con.close();
        }
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}
	
	static void operation()
	{	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Choise :-  1 : Insertion, 2 : Updation, 3 : Deletion, 4 : Display ");
			int c = sc.nextInt();
			
			switch(c)
			{
				case 1: Insertion();
				break;
				
				case 2: Updation();
				break;
				
				case 3: Deletion();
				break;
				
				case 4: Display();
				break;
				
				default:System.out.println("Invalid Choice");
				break;
			}
			
	}
	
    public static void main( String[] args )
    {
    	operation();
       
    }
}