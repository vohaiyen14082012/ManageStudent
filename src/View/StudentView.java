/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose an option: ");
    }

    public void displayStudentList(ArrayList<Student> students) {
        System.out.println("Student name\t| Semester\t| Course Name");
        for (Student student : students) {
            System.out.println(student.getStudentName() + "\t| " + student.getSemester() + "\t\t| " + student.getCourseName());
        }
    }

    public void displayStudent(Student student) {
        System.out.println("Student Details:");
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Semester: " + student.getSemester());
        System.out.println("Course Name: " + student.getCourseName());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getChoice() {
        return scanner.nextInt();
    }

public String getInput(String prompt) {
    System.out.print(prompt);
    return scanner.next().trim(); // Read the next token and trim leading/trailing spaces
}

}
