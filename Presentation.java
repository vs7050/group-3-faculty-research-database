import javax.swing.JOptionPane;
import java.util.*;
import Sources.GetInput;

public class Presentation {

   String facultyUser = "faculty";
   String facultyPassword = "faculty123";
   DataLayer dl = new DataLayer();
   
   public Presentation() {
      System.out.println("Attempting to connect to the database...\n");
      dl.connect();
      System.out.print("\nWould you like to log in as faculty? (Y/N): ");
      String yesOrNo = GetInput.readLine();
      if(yesOrNo.equals("Y")){
      
         doFacultyLoop();
      
      }
      
      dl.close();
   }

   public static void main(String[] args) {
      System.out.println("Author: Group 3");
      JOptionPane.showMessageDialog(null, "Group 3", "Author", JOptionPane.INFORMATION_MESSAGE);
      new Presentation();
   }
   
   public void doFacultyLoop(){
   
      System.out.print("\nEnter a faculty username: ");
      String user = GetInput.readLine();
      System.out.print("\nEnter faculty password: ");
      String pass = GetInput.readLine();
      if(user.equals(facultyUser) && pass.equals(facultyPassword)){
      
         System.out.println("Faculty credentials accepted.. \nLogging in!");
         
      
      }
      else{
      
         return;
      
      }
      int choice = 0;
      while(choice != 3){
      
         System.out.println("-----------------------------------------------------------------------");
         System.out.print("\nEnter an option:\n1. Add a faculty\n2. Add an abstract\n3. Exit\n\nSelection: ");
         choice = Integer.parseInt(GetInput.readLine());
         switch(choice){
            case 1:
               System.out.print("\nEnter a faculty lastname: ");
               String lName = GetInput.readLine();
               System.out.print("\nEnter a faculty firstname: ");
               String fName = GetInput.readLine();
               dl.createFaculty(lName, fName);
               break;
         
         
         }
      
      }
      
      
   
   }
}
