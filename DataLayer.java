import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class DataLayer {
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   private String sql;
   
   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";
   final String url = "jdbc:mysql://localhost/library";
   
   public DataLayer() {
   }
   
   public boolean connect() {
      String userName = "";
      Scanner s = new Scanner(System.in);
      String password = new String();
      String passwordInput = new String();
      
      try {
         Class.forName(DEFAULT_DRIVER);
         
         System.out.print("Username: ");
         userName = GetInput.readLine();
         
         System.out.print("Password: ");
         passwordInput = s.nextLine();
         
         if (passwordInput.equals("")) {
            password = "student";
         }
         else {
            password = passwordInput;
         }
         
         conn = DriverManager.getConnection(url, userName, password);
      } catch (ClassNotFoundException cnfe) {
         System.out.println("Database connection failed!");
         System.out.println("CLASS ERROR -> " + cnfe);
         System.exit(0);
      } catch (SQLException sqle) {
         System.out.println("Database connection failed!");
         System.out.println("ERROR MESSAGE -> " + sqle);
         System.exit(0);
      }
      return conn != null;
   }
   
   public int createStudent(String fname, String lname) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Student (fName, lName) VALUES (?, ?)");
         stmt.setString(1, fname);
         stmt.setString(2, lname);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
         
      }
      System.out.println("Number of records added to Student -> " + records);
      return records;
   }
   
   public int updateStudent(int studentID, String fname, String lname){
   
      int records = 0;
      try{
      
         PreparedStatement stmt = conn.prepareStatement("UPDATE student SET fname = ?, lname = ? WHERE studentID = ?");
         stmt.setString(1, fname);
         stmt.setString(2, lname);
         stmt.setInt(3, studentID);
         records = stmt.executeUpdate();
      
      }
      catch(SQLException sqle){
      
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      
      }
      
      System.out.println("Number of Student records updated -> " + records);
      return records;
   
   }
   
   public int deleteStudent(int studentID){
   
      int records = 0;
      try{
      
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE studentID = ?");
         stmt.setInt(1, studentID);
         records = stmt.executeUpdate();
      
      }
      catch(SQLException sqle){
      
         System.out.println("ERROR MESSAGE -> " +sqle);
         return 0;
      
      }
      System.out.println("Number of Student records deleted -> " + records);
      return records;
      
   
   }
   
   public int createFaculty(String lName, String fName)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Faculty (lName, fName) VALUES (?, ?)");
         stmt.setString(1, lName);
         stmt.setString(2, fName);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
      }
      System.out.println("Number of records added to Faculty -> " + records);
      return records;
   }
   
   public int updateFaculty(int facultyID, String lName, String fName)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("UPDATE Faculty SET lName = ?, fName = ? WHERE facultyID = ?");
         stmt.setString(1, lName);
         stmt.setString(2, fName);
         stmt.setInt(3, facultyID);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
      }
      System.out.println("Number of Faculty records updated -> " + records);
      return records;
   }
   
   public int deleteFaculty(int facultyID)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM Faculty WHERE facultyID = ?");
         stmt.setInt(1, facultyID);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty records deleted -> " + records);
      return records;
   }
   
   public int createFacultyInterest(int facultyID, int interestID)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO FacultyInterest (facultyID, interestID) VALUES (?, ?)");
         stmt.setInt(1, facultyID);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of records added to FacultyInterest -> " + records);
      return records;
   }
   
   public int updateFacultyInterest(int facultyID, int interestIF)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("UPDATE FacultyInterest SET interestID = ? WHERE facultyID = ?");
         stmt.setInt(1, interestID);
         stmt.setInt(2, facultyID);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of FacultyInterest records updated -> " + records);
      return records;
   }
   
   public int deleteFacultyInterest(int facultyID, int interestID)
   {
      int records = 0;
      try
      {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM Faculty WHERE facultyID = ? AND interestID = ?");
         stmt.setInt(1, facultyID);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      }
      catch (SQLException sqle) 
      {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of FacultyInterest records deleted -> " + records);
      return records;
   }
      
   public boolean close() {
      try {
         if (conn != null) {
            conn.close();
         }
         if (stmt != null) {
            stmt.close();
         }
         return true;
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return false;
      }
   }
   
   public boolean close() {
      try {
         if (conn != null) {
            conn.close();
         }
         if (stmt != null) {
            stmt.close();
         }
         return true;
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return false;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Author: Sze, Vincent");
      new DataLayer();
   }
}
