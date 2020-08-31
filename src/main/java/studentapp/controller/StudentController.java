package studentapp.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


import studentapp.model.Student;
import studentapp.service.StudentService;

@Controller
public class StudentController {

	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	StudentService service=(StudentService) context.getBean("studentservice");
	
	
	@RequestMapping(value="student/{id}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
	public String getStudent(@PathVariable("id") String id,HttpServletResponse response) {
	Gson g=new Gson();
	Student student=service.getStudent(Integer.parseInt(id));
	if(student!=null) {
		return g.toJson(student);
	}
	else {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("message", "student not found");
		response.setStatus(404);
		return g.toJson(map);
	}
}
	@RequestMapping(value = "student",method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public String addStudent(@RequestBody String studentJsonObject) {
		Gson g=new Gson();
		Student student=g.fromJson(studentJsonObject,Student.class);
	    service.addStudent(student);
	    HashMap<String, String> map=new HashMap<String, String>();
		map.put("message", "student added");
		return g.toJson(map);
	}
	
	@RequestMapping(value = "student/{id}", method = RequestMethod.DELETE, produces ="application/json")
	public void removeStudent(@PathVariable("id") int id) {
		service.deleteStudent(id);
	} 
	 @RequestMapping(value = "student",method = RequestMethod.GET,produces = "application/json")
		@ResponseBody
		public String getAllStudents() {
			Gson g=new Gson();
		 return g.toJson(service.getAllStudents());
		}
	 
}
