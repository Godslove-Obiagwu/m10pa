/*
  Student.java
  Godslove Obiagwu
  7/19/2026
  Class/application that represents a student directory
 */

package edu.fscj.cop3330c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

class StudentDirectory implements Iterable<Student> {
    private List<Student> students;

    public StudentDirectory() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> findStudentByName(String name) {
        for(Student student : students) {
            if(student.getName().equalsIgnoreCase(name)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();

        //Adding Students to the Directory
        directory.addStudent(new Student("Alice", 20));
        directory.addStudent(new Student("Bob", 22));
        directory.addStudent(new Student("Charlie", 19));

        //Iterating over the Students using the Iterator Pattern
        System.out.println("Student List:");
        for(Student student : directory) {
            System.out.println(student);
        }

        //Finding a student by name using Optional
        String searchname = "Bob";
        Optional<Student> studentOpt = directory.findStudentByName(searchname);

        //Handling the Optional Result
        studentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " + searchname + " not found.")
                );

        //Searching for a non-existent student
        String nonExistingName = "David";
        Optional<Student> nonExistingStudentOpt = directory.findStudentByName(nonExistingName);
        nonExistingStudentOpt.ifPresentOrElse(
                student -> System.out.println("Found student: " + student),
                () -> System.out.println("Student with name " + nonExistingName + " not found.")
        );
    }
}
