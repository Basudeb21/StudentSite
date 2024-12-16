# **Student Management System Documentation**

Overview
The Student Management System allows users to manage student records, including adding, updating, deleting, and searching for students based on specific attributes like roll number, name, and stream. It also supports viewing all students and searching students by stream.

The system leverages JSP for the frontend, Java Servlets for backend processing, and MySQL for the database.

Technologies Used
Frontend: JSP (JavaServer Pages)
Backend: Servlets
Database: MySQL
Database Connectivity: JDBC (Java Database Connectivity)
Development Tools: Eclipse IDE (or any Java-compatible IDE)



Core Features and Functionality
1. Add New Student
The system allows adding new students to the database by providing the following details:

Roll Number: A unique identifier for each student.
Name: The student's full name.
Stream: The stream or course the student belongs to (B.Tech, MCA, BCA, etc.).
Registration Number: Automatically generated by combining the current date and roll number.
The backend performs the following tasks:

Validates if the roll number already exists.
If the roll number is unique, the student is added to the student_tbl table.
2. Search for Student
The system allows searching for students based on:

Roll Number
Name
Stream
If no results are found, a message is displayed. The user can search for a single attribute or combine attributes (for example, by name and stream).

3. View All Students
The system allows displaying a list of all registered students from the student_tbl table.

4. Update Student Information
The system allows users to update student data. Students can be updated based on their roll number or name.

5. Delete Student
A student can be deleted by providing the roll number. The system will delete the corresponding record from the student_tbl table.

Frontend Components (JSP)
index.jsp
The main page where users can perform all CRUD operations:
Add, search, update, and delete students.
View a list of all students.
The index.jsp page interacts with the backend (Servlets) to display messages (e.g., success or error) and show the student data in a table.

Dynamic Dropdown for Stream Selection
In the Add Student form, the stream selection is provided as a dynamic dropdown. This dropdown is populated with stream names from the stream table in the database. When the page loads, the StreamDao class queries the database to fetch the available stream names and displays them in the dropdown.

Stream Names: The streams (B.Tech, MCA, BCA, etc.) are dynamically fetched from the database and shown in the dropdown.

How it Works:
When the user accesses the index.jsp page, the StreamDao retrieves all the available stream names from the stream table and stores them in a list.
This list is then passed to the JSP page, where it is used to populate the dropdown dynamically.
The user can then select a stream for the new student when adding them.
Dynamic Table for Student List
The Student List table on the index.jsp page is also dynamic. It displays all students in the database, including their roll number, name, stream, and registration number. The data for this table is fetched dynamically by querying the student_tbl table and displaying the results in the table format.


How it Works:
When a user views the page, the StudentDao fetches all student records from the student_tbl table.
These records are passed to the index.jsp page, which dynamically generates the student table.
The table displays all students, allowing users to view and interact with them (e.g., edit or delete).
Backend Components (Servlets)
ManageTask Servlet
The ManageTask Servlet handles all the main operations:

Add Student: Adds a new student to the database.
Refresh Page: Clears session attributes like messages and student lists.
Search Students: Searches students by roll number, name, or stream.
Search All Students: Retrieves and displays all students.
Update Student: Updates student information.
Delete Student: Deletes a student by roll number.
StudentDao (Data Access Object)
This class provides the actual database operations (CRUD) using SQL queries stored in the Query interface.

StreamDao
This class retrieves all available streams from the database for the dropdown in the frontend.

Helper Classes
ConnectionProvider
Handles database connections by providing a static method to get a MySQL connection using credentials defined in DBUtilities.

DBUtilities
Stores the database connection properties (e.g., database URL, username, password).

How to Use
1. Add Student
On the index.jsp page, enter the roll number, name, and select the stream from the dynamic dropdown for the new student.
Click "Add Student" to add the student to the database.
2. Search Student
On the index.jsp page, enter a roll number, name, or stream in the search fields.
Click "Search" to find students based on the entered data.
3. View All Students
The student list is dynamically displayed in a table, where users can see all registered students.
4. Update or Delete Student
Click on the respective buttons on the page to update or delete a student based on their roll number.
