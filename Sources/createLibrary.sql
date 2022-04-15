DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
USE library;

CREATE TABLE Student(
   studentID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   lName VARCHAR(50) NOT NULL,
   fName VARCHAR(50) NOT NULL,
   PRIMARY KEY (studentID)
);

CREATE TABLE Faculty(
   facultyID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   lName VARCHAR(50) NOT NULL,
   fName VARCHAR(50) NOT NULL,
   PRIMARY KEY (facultyID)
);

CREATE TABLE Abstract(
   abstractID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   abstract VARCHAR(300) NOT NULL,
   abstractDate DATE NOT NULL,
   PRIMARY KEY (abstractID)
);

CREATE TABLE Interest(
   interestID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   interest VARCHAR(50) NOT NULL,
   PRIMARY KEY (interestID)
);

CREATE TABLE StudentContact(
   studentID INT UNSIGNED,
   roomNumber VARCHAR(8),
   phoneNumber VARCHAR(12),
   emailAddress VARCHAR(50),
   PRIMARY KEY (studentID),
   CONSTRAINT student_studentID_pk FOREIGN KEY (studentID) REFERENCES Student(studentID)
);

CREATE TABLE FacultyContact(
   facultyID INT UNSIGNED,
   roomNumber VARCHAR(8),
   phoneNumber VARCHAR(12),
   emailAddress VARCHAR(50),
   officeHours VARCHAR(50),
   PRIMARY KEY (facultyID),
   CONSTRAINT faculty_facultyID_pk FOREIGN KEY (facultyID) REFERENCES Faculty(facultyID)
);

CREATE TABLE StudentInterest(
	studentID INT UNSIGNED NOT NULL,
	interestID INT UNSIGNED NOT NULL,
	PRIMARY KEY (studentID, interestID),
	CONSTRAINT studentinterest_student_FK FOREIGN KEY (studentID) 
		REFERENCES student(studentID)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
      
	CONSTRAINT studentinterest_interest_FK FOREIGN KEY (interestID)    
		REFERENCES interest(interestID)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE FacultyInterest(
	facultyID INT UNSIGNED NOT NULL,
	interestID INT UNSIGNED NOT NULL,
	PRIMARY KEY (facultyID, interestID),
	CONSTRAINT facultyinterest_faculty_FK FOREIGN KEY (facultyID) 
		REFERENCES faculty(facultyID)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
      
	CONSTRAINT facultyinterest_interest_FK FOREIGN KEY (interestID)    
		REFERENCES interest(interestID)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE FacultyAbstract(
	facultyID INT UNSIGNED NOT NULL,
	abstractID INT UNSIGNED NOT NULL,
	PRIMARY KEY (facultyID, abstractID),
	CONSTRAINT facultyabstract_faculty_FK FOREIGN KEY (facultyID) 
		REFERENCES faculty(facultyID)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
      
	CONSTRAINT facultyabstract_abstract_FK FOREIGN KEY (abstractID)    
		REFERENCES abstract(abstractID)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
