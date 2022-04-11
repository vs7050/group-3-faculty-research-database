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
   
   public int countStaff() {
      int row = 0;
      try {
         stmt = conn.createStatement();
         sql = "SELECT COUNT(*) FROM staff";
         rs = stmt.executeQuery(sql);
         rs.next();
         row = rs.getInt(1);
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         System.exit(0);
      }
      return row;
   }
   
   public void createStudent(String fname, String lname) {
      try {
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Student (fName, lName) VALUES (?, ?));
         stmt.setString(1, fname);
         stmt.setString(2, lname);
         stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         System.exit(0);
      }
   }

   public int deletePhoneRecords(int passengerID) {
      int numRowsDel = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM phone WHERE passengerID = ?");
         stmt.setInt(1, passengerID);
         
         numRowsDel = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         System.exit(0);
      }
      return numRowsDel;
   }
   
   public int updateEquipment(int equipID, String equipmentName, String equipmentDescription, int equipmentCapacity) {
      int numRowsUpdated = 0;
      try {
         PreparedStatement stmt = conn.prepareStatement("UPDATE equipment SET equipmentName = ?, equipmentDescription = ?, equipmentCapacity = ? WHERE equipID = ?");
         stmt.setString(1, equipmentName);
         stmt.setString(2, equipmentDescription);
         stmt.setInt(3, equipmentCapacity);
         stmt.setInt(4, equipID);
         
         numRowsUpdated = stmt.executeUpdate();
      } catch (SQLException sqle) {
         System.out.println("ERROR MESSAGE -> " + sqle);
         System.exit(0);
      }
      return numRowsUpdated;
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
