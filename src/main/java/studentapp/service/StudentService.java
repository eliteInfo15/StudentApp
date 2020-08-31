package studentapp.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import studentapp.daoimpl.StudentDAOImpl;
import studentapp.model.Student;

@Service 
@Component 
public class StudentService {

	private StudentDAOImpl studentDAOImpl;

	public StudentDAOImpl getStudentDAOImpl() {
		return studentDAOImpl;
	}

	public void setStudentDAOImpl(StudentDAOImpl studentDAOImpl) {
		this.studentDAOImpl = studentDAOImpl;
	}
	public void addStudent(Student student) {
		studentDAOImpl.addStudent(student);
	}
	public Student getStudent(int id) {
		return studentDAOImpl.getStudent(id);
	}
	public List<Student> getAllStudents(){
		return studentDAOImpl.getAllStudents();
	}
	public void deleteStudent(int id) {
		studentDAOImpl.removeStudent(id);
	}
}
