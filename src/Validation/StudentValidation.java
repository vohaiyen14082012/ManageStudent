/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

public class StudentValidation {
    public boolean validateName(String name) {
        return !name.isEmpty();
    }

    public boolean validateSemester(int semester) {
        return semester > 0;
    }

    public boolean validateCourse(String course) {
        return course.equals("Java") || course.equals(".Net") || course.equals("C/C++");
    }

    public boolean validateId(int id) {
        return id > 0;
    }
}
