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

INSERT INTO Faculty (lName, fName) VALUES ("Habermas", "Jim"), ("George", "Defenbaugh"), ("Richard", "Smedley"),("Barbara", "Ericson");

CREATE TABLE Abstract(
   abstractID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   abstract VARCHAR(1000) NOT NULL,
   abstractDate DATE NOT NULL,
   PRIMARY KEY (abstractID)
);

INSERT INTO Abstract (abstract, abstractDate) VALUES 
	("This book, Learn C and C++ by Samples written by James R. Habermas, is a companion to A First Book Ansi C++ by Gary Bronson.  It is the author’s firm belief that one can never have too many samples.  If a textbook is to be useful, it needs primary support through an instructor and/or more samples.  This textbook contains a wealth of useful C & C++ samples that are fashioned to further demonstrate the topics outlined in the text.", 
		"1999-01-01"), 
    ("This book presents ‘standard’ C, i.e., code that compiles cleanly with a compiler that meets the ANSI C standard.  This book has over 90 example programs that illustrate the topics of each chapters.  In addition complete working programs are developed fully, from design to program output.  This book is filled with Antibugging Notes (the stress traps to be avoided), and Quick Notes, that emphasize important points to be remembered.", 
		"1998-01-01"), 
    ("The programming language used in this book is Python.  Python has been described as “executable pseudo-code.”  I have found that both computer science majors and non majors can learn Python.  Since Python is actually used for communications tasks (e.g., Web site Development), it’s relevant language for an in introductory computing course.  The specific dialect of Python used in this book is Jython.  Jython is Python.  The differences between Python (normally implemented in C) and Jython (which is implemented in Java) are akin to the differences between any two language implementations (e.g., Microsoft vs. GNU C++ implementations).",
		"2008-12-31");
        
CREATE TABLE Interest(
   interestID INT UNSIGNED NOT NULL AUTO_INCREMENT,
   interest VARCHAR(50) NOT NULL,
   PRIMARY KEY (interestID)
);

INSERT INTO Interest (interest) VALUES ("Python"), ("Java"), ("C++"), ("C#"), ("C"), ("Pascal"), ("SQL"), ("JavaScript"), ("PHP"), ("HTML"), ("CSS");

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

INSERT INTO FacultyAbstract (facultyID, abstractID) VALUES (1, 1), (2, 2), (3, 2), (4, 3);
