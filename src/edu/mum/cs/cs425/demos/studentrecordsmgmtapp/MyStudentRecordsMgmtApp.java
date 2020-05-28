package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(110001, "Dave", LocalDate.of(1951, 11, 18)));
		studentList.add(new Student(110002, "Anna", LocalDate.of(1990, 12, 7)));
		studentList.add(new Student(110003, "Erica", LocalDate.of(1974, 1, 31)));
		studentList.add(new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)));
		studentList.add(new Student(110005, "Bob", LocalDate.of(1990, 3, 5)));
		
		printListOfStudents(studentList);
		System.out.println();
		getListOfPlatinumAlumniStudents(studentList);
	}

	static void printListOfStudents(List<Student> studentList) {
		studentList.stream()
				   .sorted((stu1, stu2) ->
				   		stu1.getName().compareTo(stu2.getName()
				   ))
				   .forEach(System.out::println);
	}

	static void getListOfPlatinumAlumniStudents(List<Student> studentList) {
		studentList.stream()
				   .filter(student ->
				   		student.getDateOfAdmission().isBefore(LocalDate.now().minusYears(30))
				   )
				   .forEach(System.out::println);
	}

}
