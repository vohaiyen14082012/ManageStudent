/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Contrroller.StudentController;
import Model.Student;
import Validation.StudentValidation;
import View.StudentView;
import java.util.ArrayList;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentController controller = new StudentController();
        StudentValidation validation = new StudentValidation();

        while (true) {
            view.displayMenu();
            int choice = view.getChoice();

            switch (choice) {
                case 1:
                    String studentName = view.getInput("Enter Student Name: ");
                    int semester = Integer.parseInt(view.getInput("Enter Semester: "));
                    String courseName = view.getInput("Enter Course Name (Java, .Net, C/C++): ");

                    if (validation.validateName(studentName) && validation.validateSemester(semester) && validation.validateCourse(courseName)) {
                        controller.createStudent(studentName, semester, courseName);
                        view.displayMessage("Student added successfully.");
                    } else {
                        view.displayMessage("Invalid input. Please check your input values.");
                    }
                    break;
                case 2:
                    String searchName = view.getInput("Enter part of student name to search: ");
                    ArrayList<Student> foundStudents = controller.findAndSortStudents(searchName);
                    view.displayStudentList(foundStudents);
                    break;
                case 3:
                    int studentId = Integer.parseInt(view.getInput("Enter Student ID to update or delete: "));
                    String choiceUD = view.getInput("Do you want to update (U) or delete (D) this student? ");

                    if (choiceUD.equalsIgnoreCase("U")) {
                        String newName = view.getInput("Enter new Student Name: ");
                        int newSemester = Integer.parseInt(view.getInput("Enter new Semester: "));
                        String newCourse = view.getInput("Enter new Course Name: ");

                        if (validation.validateName(newName) && validation.validateSemester(newSemester) && validation.validateCourse(newCourse)) {
                            if (controller.updateStudent(studentId, newName, newSemester, newCourse)) {
                                view.displayMessage("Student updated successfully.");
                            } else {
                                view.displayMessage("Student not found.");
                            }
                        } else {
                            view.displayMessage("Invalid input. Please check your input values.");
                        }
                    } else if (choiceUD.equalsIgnoreCase("D")) {
                        if (controller.deleteStudent(studentId)) {
                            view.displayMessage("Student deleted successfully.");
                        } else {
                            view.displayMessage("Student not found.");
                        }
                    } else {
                        view.displayMessage("Invalid choice. No changes made.");
                    }
                    break;
                case 4:
                    ArrayList<Student> studentList = controller.getStudentList();
                    view.displayStudentList(studentList);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Invalid choice. Please select a valid option.");
            }
        }
    }
}
