/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrroller;

import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();
    private int nextId = 1;

    public void createStudent(String studentName, int semester, String courseName) {
        Student student = new Student(nextId++, studentName, semester, courseName);
        studentList.add(student);
    }

    public ArrayList<Student> findAndSortStudents(String searchName) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentName().contains(searchName)) {
                foundStudents.add(student);
            }
        }

        Collections.sort(foundStudents, new StudentComparator());
        return foundStudents;
    }

public boolean updateStudent(int studentId, String newName, int newSemester, String newCourse) {
    for (Student student : studentList) {
        if (student.getId() == studentId) {
            student.setStudentName(newName);
            student.setSemester(newSemester);
            student.setCourseName(newCourse);
            return true;
        }
    }
    return false;
}

    public boolean deleteStudent(int studentId) {
        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    private class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getStudentName().compareTo(s2.getStudentName());
        }
    }
}
