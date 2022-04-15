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
         stmt.setDate(2, absDate);
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
         stmt.setDate(2, absDate);
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
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
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
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
         stmt.setInt(3, );
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Contacts updated -> " + records);
      return records;
   } // updateStudentContact

   public int deleteStudentContact(int studentID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
         stmt.setInt(3, );
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
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
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
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
         stmt.setInt(3, );
         records = stmt.executeUpdate();
      } catch(SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }

      System.out.println("Number of Student Interests updated -> " + records);
      return records;
   } // updateStudentInterest

   public int deleteStudentInterest(int studentID, int interestID) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setString(1, );
         stmt.setString(2, );
         stmt.setInt(3, );
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

   public int createFacultyContact(int facultyID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setInt(1, );
         stmt.setInt(2, );
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Contacts added -> " + records);
      return records;
   } // createFacultyInterest

   public int updateFacultyContact(int facultyID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setInt(1, );
         stmt.setInt(2, );
         records = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         return 0;
      }
      System.out.println("Number of Faculty Contacts updated -> " + records);
      return records;
   } // updateFacultyContact

   public int deleteFacultyContact(int facultyID, int roomNumber, String phoneNumber, String emailAddress) {
      int records = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("");
         stmt.setInt(1, );
         stmt.setInt(2, );
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
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO FacultyInterest (facultyID, interestID) VALUES (?, ?)");
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
         PreparedStatement stmt = conn.prepareStatement("UPDATE FacultyInterest SET interestID = ? WHERE facultyID = ?");
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
