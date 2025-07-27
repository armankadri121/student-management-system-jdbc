# 🎓 Student Management System (Java + JDBC + MySQL)

A **console-based student management system** built using **Java**, **JDBC**, and **MySQL**. This project allows you to perform basic CRUD (Create, Read, Update, Delete) operations on student data using a relational database backend.

---

## 📌 Features

- ➕ Add a new student  
- 📋 View all students  
- 🔍 Search student by ID  
- ✏️ Update student details  
- ❌ Delete student by ID  
- 💾 Persistent data storage with MySQL

---

## 🛠 Technologies Used

| Tool          | Purpose                         |
|---------------|----------------------------------|
| Java          | Programming language             |
| JDBC          | Java Database Connectivity       |
| MySQL         | Database for storing student data|
| MySQL Workbench | GUI client for managing DB     |
| Maven         | Build & dependency management    |
| IntelliJ IDEA | (or any IDE) for development     |

---

## 🗂️ Project Structure

student-management-jdbc/
├── src/
│ ├── Student.java
│ ├── StudentDAO.java
│ └── Main.java
├── pom.xml
└── README.md


---

## 🧱 Database Schema

```sql

CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  age INT,
  course VARCHAR(100)
);

```

## 🚀 How to Run

---

###1. Clone the repo
git clone https://github.com/armankadri121/student-management-system-jdbc.git
cd student-management-jdbc

###2. Setup MySQL DB
Create the database and table using the schema above.

###3. Update DB Credentials
In StudentDAO.java, modify:

String jdbc = "jdbc:mysql://localhost:3306/student_db";
String username = "your_mysql_username";
String password = "your_mysql_password";

###4. Build and Run
Use your IDE or run with Maven:
mvn compile
mvn exec:java -Dexec.mainClass=Main



## 📷 Sample Output
Student Management Menu
1. Add new student
2. View all students
3. Update student by ID
4. Delete student by ID
5. Search student by ID
6. Search student by Name
0. Exit
Enter your choice:

```





