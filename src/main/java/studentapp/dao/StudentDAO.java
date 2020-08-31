package studentapp.dao;

import java.util.List;

import studentapp.model.Student;



public interface StudentDAO {

	void addStudent(Student student);
	List<Student> getAllStudents();
	Student getStudent(int id);
	void removeStudent(int id);
}
