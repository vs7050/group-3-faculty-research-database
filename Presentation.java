import javax.swing.JOptionPane;
import java.util.*;

public class Presentation {

   String facultyUser = "faculty";
   String facultyPassword = "faculty123";
   DataLayer dl = new DataLayer();
   
   public Presentation() {
      System.out.println("Welcome to the Faculty and Student Connection Database!");
      
      
      boolean keepGoing = true;
      while(keepGoing){
         
         System.out.print("Would you like to log in as a Student or Faculty?(student/faculty): ");
         String choice = GetInput.readLine();
      
         if(choice.equals("faculty")){
         
            System.out.println("Attempting to connect to the database...\n");
            dl.connect();
            doFacultyLoop();
            keepGoing = false;
         
         }
         else if(choice.equals("student")){
         
            System.out.println("Attempting to connect to the database...\n");
            dl.connect();
            doStudentLoop();
            keepGoing = false;
         
         }
         else{
         
            System.out.println("Please enter a valid choice!\n");
            keepGoing = true;
         
         }
         
      }
      
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
            case 2:
               System.out.print("\nEnter abstract text here: ");
               String abs = GetInput.readLine();
               System.out.print("\nEnter the abstract date(YYYY-MM-DD): ");
               String date = GetInput.readLine();
               dl.createAbstract(abs, date);
               break;
            case 3:
               break;
         
         }
      
      } 
   
   }
   // loop for the student to choose options
   public void doStudentLoop(){
   
      int choice = 0;
      int records = 0;
      while(choice != 3){
      
         System.out.println("\n-----------------------------------------------------------------------");
         System.out.print("\nEnter an option:\n1. Add Student\n2. Add Student Contact\n3. Add Interests\n4. Exit\n\nSelection: ");
         choice = Integer.parseInt(GetInput.readLine());
         switch(choice){
         
            case 1:
               System.out.print("\nEnter a student first name: ");
               String fname = GetInput.readLine();
               System.out.print("\nEnter a student last name: ");
               String lname = GetInput.readLine();
               records = dl.createStudent(fname, lname);
               System.out.println("Amount of records added to student -> " + records);
               dl.doSeeStudents();
               break;
            case 2:
               dl.doSeeStudents();
               System.out.print("\nEnter a student ID: ");
               int studentID = GetInput.readInt();
               System.out.print("\nEnter a room number: ");
               int roomNum = GetInput.readInt();
               System.out.print("\nEnter a phone number: ");
               String phoneNum = GetInput.readLine();
               System.out.print("\nEnter an email address: ");
               String email = GetInput.readLine();
               records = dl.createStudentContact(studentID, roomNum, phoneNum, email);
               System.out.println("Amount of records added to student contact -> " + records);
               break;
            case 3:
               dl.doSeeStudents();
               System.out.print("\nEnter a student ID: ");
               int sID = GetInput.readInt();
               System.out.print("\nEnter a interest ID: ");
               int iID = GetInput.readInt();
               records = dl.createStudentInterest(sID, iID);
               System.out.println("Amount of records added to studentInterest -> " + records);
               break;
            case 4:
               break;
         
         }
      
      }
   
   }
}
