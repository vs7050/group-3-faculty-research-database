

import java.sql.*;
import javax.swing.JOptionPane;

public class Presentation {
   DataLayer dl = new DataLayer();
   
   
   public Presentation() {
      System.out.println("Connecting to travel database...");
      dl.connect();
      
      dl.close();
   }

   public static void main(String[] args) {
      System.out.println("Author: Group 3");
      JOptionPane.showMessageDialog(null, "Group 3", "Author", JOptionPane.INFORMATION_MESSAGE);
      new Presentation();
   }
}