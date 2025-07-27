package com.student;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import java.awt.*;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
        String dbUser = "root";
        String dbPassword = ""; // Enter your password here

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Scanner scanner = new Scanner(System.in)){

            StudentDAO dao = new StudentDAO(conn);
            // 1. Connect to the database
//            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("✅ Connection successful!");

            while (true) {
                System.out.println("\n Student Management Menu");
                System.out.println("1. Add new student");
                System.out.println("2. View all students");
                System.out.println("3. Update student by ID");
                System.out.println("4. Delete student by ID");
                System.out.println("5. Search student by ID");
                System.out.println("6. Search student by Name");
                System.out.println("0. Exit");
                System.out.println("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();

                        dao.insertStudent(new Student(name, age, email));
                        System.out.println("Student added..!");
                    }

                    case 2 -> {
                        List<Student> list = dao.getAllStudents();
                        for (Student s: list) {
                            System.out.println(s);
                        }
                    }

                    case 3 -> {
                        System.out.println("Enter ID to update: ");

                        int updatedId = scanner.nextInt();
                        scanner.nextLine();

                        Student student = dao.getStudentById(updatedId);
                        if (student == null) {
                            System.out.println("No student found!");
                        }
                        else {
                            System.out.print("New Name: ");
                            student.setName(scanner.nextLine());
                            System.out.print("New Age");
                            student.setAge(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("New Email: ");
                            student.setEmail(scanner.nextLine());
                            dao.updateStudent(student);
                            System.out.println("Updated Successfully...!");
                        }
                    }

                    case 4 -> {
                        System.out.println("Enter ID to delete: ");
                        int deleteID = scanner.nextInt();

                        dao.deleteStudent(deleteID);
                        System.out.println("Deleted");
                    }

                    case 5 -> {
                        System.out.println("Search student by: ");
                        int id = scanner.nextInt();
                        Student s = dao.getStudentById(id);
                        if (s != null) System.out.println(s);
                        else System.out.println("Not found.");
                    }

                    case 6 -> {
                        System.out.print("Enter name to search: ");
                        String name = scanner.nextLine();
                        List<Student> results = dao.searchByName(name);
                        if (results.isEmpty()) {
                            System.out.println("No matches found");
                        }
                        else {
                            for (Student s: results) {
                                System.out.println(s);
                            }
                        }
                    }

                    case 0 -> {
                        System.out.println("Exiting, GoodBye...!");
                        return;
                    }

                    default -> System.out.println("Invalid Choice try again");
                }
            }
        }
        catch (SQLException e) {
            System.out.println("DB Error");
            e.printStackTrace();
        }
    }
}
