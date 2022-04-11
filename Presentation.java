// Vincent Sze
// Practical 01 - ISTE-330
// 2/18/22

import java.sql.*;
import javax.swing.JOptionPane;

public class Presentation {
   DataLayer dl = new DataLayer();
   private int columns;
   
   public Presentation() {
      System.out.println("Connecting to travel database...");
      dl.connect();
      System.out.println("DB Connected(Sze, Vincent)");
      
      columns = dl.countStaff();
      System.out.println("Number of records in staff: " + columns);
      
      int passengerID = 0;
      int equipID = 0;
      String equipmentName = "";
      String equipmentDescription = "";
      int equipmentCapacity = 0;

      System.out.print("Which person's phone would you like to delete: ");
      passengerID = GetInput.readLineInt();
      dl.deletePhoneRecords(passengerID);
      
      System.out.print("Which equipment ID would you like to update?");
      equipID = GetInput.readLineInt();
      
      System.out.print("Updated equipment name: ");
      equipmentName = GetInput.readLine();
      
      System.out.print("Updated equipment description: ");
      equipmentDescription = GetInput.readLine();
      
      System.out.print("Updated equipment capacity: ");
      equipmentCapacity = GetInput.readLineInt();
      dl.updateEquipment(equipID, equipmentName, equipmentDescription, equipmentCapacity);
      
      dl.close();
   }

   public static void main(String[] args) {
      System.out.println("Author: Group 3");
      JOptionPane.showMessageDialog(null, "Group 3", "Author", JOptionPane.INFORMATION_MESSAGE);
      new Presentation();
   }
}