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
   
   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";
   final String url = "jdbc:mysql://localhost/library";
   
   public DataLayer() {
   }
   
   public boolean connect() {
      String userName = "";
      String password = new String();
      String passwordInput = new String();

      try {
         Class.forName(DEFAULT_DRIVER);
         
         System.out.print("Username (default - root): ");
         userName = GetInput.readLine();
         if(userName.equals("")){
            
            userName = "root";
         
         }
         
         System.out.print("Password (default - student): ");
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
   } // connect

   /* INTEREST */

   public int createInterest(String interest) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO interest (interest) VALUES (?)");
         stmt.setString(1, interest);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Interest records added -> " + records);
      return records;
   } // createInterest

   public int updateInterest(int interestID, String interest) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE interest SET interest = ? WHERE interestID = ?");
         stmt.setString(1, interest);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Interest records updated -> " + records);
      return records;
   } // updateInterest

   public int deleteInterest(int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM interest WHERE interestID = ?");
         stmt.setInt(1, interestID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Interest records deleted -> " + records);
      return records;
   } // deleteInterest

   /* ABSTRACT */

   public int createAbstract(String abs, String absDate) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO abstract (abstract, abstractDate) VALUES (?, ?)");
         stmt.setString(1, abs);
         stmt.setDate(2, java.sql.Date.valueOf(absDate));
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Abstract records added -> " + records);
      return records;
   } // createAbstract

   public int udpateAbstract(int absID, String abs, String absDate) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE abstract SET abstract = ?, abstractDate = ? WHERE abstractID = ?");
         stmt.setString(1, abs);
         stmt.setDate(2, java.sql.Date.valueOf(absDate));
         stmt.setInt(3, absID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Abstract records updated -> " + records);
      return records;
   } // udpateAbstract

   public int deleteAbstract(int abstractID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM abstract WHERE abstractID = ?");
         stmt.setInt(1, abstractID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Abstract records deleted -> " + records);
      return records;
   } // deleteAbstract
   
   /* STUDENT */

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

      System.out.println("Number of Student records added -> " + records);
      return records;
   } // createStudent
   
   public int updateStudent(int studentID, String fname, String lname) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE student SET fname = ?, lname = ? WHERE studentID = ?");
         stmt.setString(1, fname);
         stmt.setString(2, lname);
         stmt.setInt(3, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student records updated -> " + records);
      return records;
   } // updateStudent
   
   public int deleteStudent(int studentID){
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE studentID = ?");
         stmt.setInt(1, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " +sqle);
         return 0;
      }

      System.out.println("Number of Student records deleted -> " + records);
      return records;
   } // deleteStudent

   public int createStudentContact(int studentID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO studentcontact VALUES (?, ?, ?, ?)");
         stmt.setInt(1, studentID);
         stmt.setInt(2, roomNumber);
         stmt.setString(3, phoneNumber);
         stmt.setString(4, emailAddress);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " +sqle);
         return 0;
      }

      System.out.println("Number of Student Contacts updated -> " + records);
      return records;
   } // createStudentContact

   public int updateStudentContact(int studentID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE studentcontact SET roomNumber = ?, phoneNumber = ?, emailAddress = ? WHERE studentID = ?");
         stmt.setInt(1, roomNumber);
         stmt.setString(2, phoneNumber);
         stmt.setString(3, emailAddress);
         stmt.setInt(4, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Contacts updated -> " + records);
      return records;
   } // updateStudentContact

   public int deleteStudentContact(int studentID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM studentContact WHERE studentID = ?");
         stmt.setInt(1, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Contacts deleted -> " + records);
      return records;
   } // deleteStudentContact

   public int createStudentInterest(int studentID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO studentinterest VALUES (? , ?)");
         stmt.setInt(1, studentID);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " +sqle);
         return 0;
      }

      System.out.println("Number of Student Interests added -> " + records);
      return records;
   } // createStudentInterest

   public int updateStudentInterest(int studentID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE studentinterest SET interestID = ? WHERE studentID = ?");
         stmt.setInt(1, interestID);
         stmt.setInt(2, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Interests updated -> " + records);
      return records;
   } // updateStudentInterest

   public int deleteStudentInterest(int studentID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM studentinterest WHERE studentID = ?");
         stmt.setInt(1, studentID);
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Interests deleted -> " + records);
      return records;
   } // deleteStudentInterest
   
   /* FACULTY */

   public int createFaculty(String lName, String fName) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Faculty (lName, fName) VALUES (?, ?)");
         stmt.setString(1, lName);
         stmt.setString(2, fName);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Faculty records added -> " + records);
      return records;
   } // createFaculty
   
   public int updateFaculty(int facultyID, String lName, String fName) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE Faculty SET lName = ?, fName = ? WHERE facultyID = ?");
         stmt.setString(1, lName);
         stmt.setString(2, fName);
         stmt.setInt(3, facultyID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Faculty records updated -> " + records);
      return records;
   } // updateFaculty
   
   public int deleteFaculty(int facultyID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM Faculty WHERE facultyID = ?");
         stmt.setInt(1, facultyID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty records deleted -> " + records);
      return records;
   } // deleteFaculty

   public int createFacultyContact(int facultyID, int roomNumber, String phoneNumber, String emailAddress, String officeHours) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO facultycontact (facultyID, roomNumber, phoneNumber, emailAddress, officeHours) VALUES (?, ?, ?, ?, ?)");
         stmt.setInt(1, facultyID);
         stmt.setInt(2, roomNumber);
         stmt.setString(3, phoneNumber);
         stmt.setString(4, emailAddress);
         stmt.setString(5, officeHours);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Contacts added -> " + records);
      return records;
   } // createFacultyInterest

   public int updateFacultyContact(int facultyID, int roomNumber, String phoneNumber, String emailAddress, String officeHours) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE facultycontact SET roomNumber = ?, phoneNumber = ?, emailAddress = ?, officeHours = ? WHERE facultyID = ?");
         stmt.setInt(2, roomNumber);
         stmt.setString(3, phoneNumber);
         stmt.setString(4, emailAddress);
         stmt.setString(5, officeHours);
         stmt.setInt(1, facultyID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Contacts updated -> " + records);
      return records;
   } // updateFacultyContact

   public int deleteFacultyContact(int facultyID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM facultycontact WHERE facultyID = ?");
         stmt.setInt(1, facultyID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Contacts deleted -> " + records);
      return records;
   } // deleteFacultyContact
   
   public int createFacultyInterest(int facultyID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO facultyinterest (facultyID, interestID) VALUES (?, ?)");
         stmt.setInt(1, facultyID);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Interests added -> " + records);
      return records;
   } // createFacultyInterest
   
   public int updateFacultyInterest(int facultyID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE facultyinterest SET interestID = ? WHERE facultyID = ?");
         stmt.setInt(1, interestID);
         stmt.setInt(2, facultyID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Interests updated -> " + records);
      return records;
   } // updateFacultyInterest
   
   public int deleteFacultyInterest(int facultyID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM Faculty WHERE facultyID = ? AND interestID = ?");
         stmt.setInt(1, facultyID);
         stmt.setInt(2, interestID);
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Interests deleted -> " + records);
      return records;
   } // deleteFacultyInterest
   
   // will list off the students with IDs
   public void doSeeStudents(){
   
      System.out.print("Would you like to see a list of all the students?(Y/N): ");
      String yesNo = GetInput.readLine();
      if(yesNo.equals("Y")){
      
         try{
            String query = "SELECT * FROM student";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
            
               int id = rs.getInt(1);
               String lname = rs.getString(2);
               String fname = rs.getString(3);
               System.out.println("\nStudent ID: " + id + " Student Name: " + lname + ", " + fname);
            
            
            }
         }
         catch(SQLException sqle){
         
            System.out.println("ERROR MESSAGE -> " + sqle);
         
         }
      
      }
   
   }// end of doSeeStudents
      
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
   } // close
   
   public static void main(String[] args) {
      System.out.println("Author: Group 3");
      new DataLayer();
   } // main method
} // end of DataLayer
