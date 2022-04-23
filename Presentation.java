import javax.swing.JOptionPane;
import java.util.*;
import Sources.GetInput;

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
      int records = 0;
      while(choice != 3){
      
         System.out.println("-----------------------------------------------------------------------");
         System.out.print("\nEnter an option:\n1. Add a faculty\n2. Add faculty contact \n3. Add faculty interests \n4. Add an abstract\n5. Delete Faculty \n6. Delete Student \n7. Update Faculty \n8. Exit\n\nSelection: ");
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
               dl.doSeeFaculty();
               System.out.print("\nEnter your faculty ID: ");
               int facID = GetInput.readInt();
               System.out.print("\nEnter your room number: ");
               int room = GetInput.readInt();
               System.out.print("\nEnter your phone number: ");
               String pn = GetInput.readLine();
               System.out.print("\nEnter your email address: ");
               String emailAd = GetInput.readLine();
               System.out.print("\nEnter your office hours: ");
               String officeHours = GetInput.readLine();
               records = dl.createFacultyContact(facID, room, pn, emailAd, officeHours);
               System.out.println("Amount of records added to faculty contact -> " + records);
               break;
            case 3:
               dl.doSeeFaculty();
               dl.doSeeInterest();
               System.out.print("\nEnter a faculty ID: ");
               int facultID = GetInput.readInt();
               System.out.print("\nEnter an interest ID: ");
               int intID = GetInput.readInt();
               records = dl.createFacultyInterest(facultID, intID);
               System.out.println("Amount of records added to faculty interest -> " + records);
            case 4:
               System.out.print("\nEnter abstract text here: ");
               String abs = GetInput.readLine();
               System.out.print("\nEnter the abstract date(YYYY-MM-DD): ");
               String date = GetInput.readLine();
               records = dl.createAbstract(abs, date);
               System.out.println("Amount of records added to abstract -> " + records);
               break;
            case 5:
               dl.doSeeFaculty();
               System.out.print("\nEnter a faculty ID: ");
               int fID = GetInput.readInt();
               records = dl.deleteFaculty(fID);
               System.out.println("Amount of records deleted from faculty -> " + records);
               break;
            case 6:
               dl.doSeeStudents();
               System.out.print("\nEnter a student ID: ");
               int stID = GetInput.readInt();
               records = dl.deleteStudent(stID);
               System.out.println("Amount of records deleted from student -> " + records);
               break;
            case 7:
               dl.doSeeFaculty();
               System.out.print("\nEnter a facultyID to update: ");
               int facuID = GetInput.readInt();
               System.out.print("\nEnter a first name to update: ");
               String firstname = GetInput.readLine();
               System.out.print("\nEnter a last name to update: ");
               String lastname = GetInput.readLine();
               records = dl.updateFaculty(facuID, lastname, firstname);
               System.out.println("Amount of records updated from faculty -> " + records);
               break;
            case 8:
               return;
         
         }
      
      } 
   
   }// end facultyloop
   
   // loop for the student to choose options
   public void doStudentLoop(){
   
      int choice = 0;
      int records = 0;
      while(choice != 3){
      
         System.out.println("\n-----------------------------------------------------------------------");
         System.out.print("\nEnter an option:\n1. Add Student\n2. Add Student Contact\n3. Add Interests\n4. Search Faculty Interests\n5. Exit\n\nSelection: ");
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
               System.out.print("\nEnter interest to search: ");
               String keyword = GetInput.readLine();
               dl.searchFacultyInterest(keyword);
               break;
            case 5:
               return;
         
         }
      
      }
   
   }
}
