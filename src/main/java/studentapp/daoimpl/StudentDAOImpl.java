package studentapp.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import studentapp.dao.StudentDAO;
import studentapp.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private HibernateTemplate hibernateTemplate;
	 
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

	public void addStudent(Student student) {
		hibernateTemplate.save(student);
	}

	public List<Student> getAllStudents() {
		return hibernateTemplate.loadAll(Student.class);
	}

	public Student getStudent(int id) {
		return hibernateTemplate.get(Student.class, id);
	}

	public void removeStudent(int id) {
      hibernateTemplate.delete(getStudent(id));
	}

	
}
