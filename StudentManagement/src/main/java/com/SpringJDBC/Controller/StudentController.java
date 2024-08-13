package com.SpringJDBC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringJDBC.DAO.StudentDAO;
import com.SpringJDBC.Entity.StudentEntity;
import com.SpringJDBC.Service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/show")
	public String showStudent(Model model) {
		System.out.println("inside showStudent method");
		List<StudentEntity> studentList=studentService.loadStudent();
		model.addAttribute("students", studentList);
		return "student-list";
		
	}
	
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		
		model.addAttribute("student", new StudentEntity());
		return "add-student";
		
	}
	
	
	@PostMapping("/save-student")
	public String saveStudent(StudentEntity student) {
		if(student.getId()==0) {
			
			studentService.saveStudent(student);	
		}
		else {
			studentService.updateStudent(student);
		}
			
		
		System.out.println(student);
		return "redirect:/show";
		
	}
	
	/*public String updateStudent(Model model) {
	StudentEntity existingStudent=new StudentEntity();
	model.addAttribute("student", existingStudent);*/
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id ,Model model ) {
		
		System.out.println(id);
		StudentEntity student2=studentService.getStudent(id);
		System.out.println(student2);
		/*public String updateStudent(@RequestParam("userId") int id ,@ModelAttribute("student") StudentEntity existingStudent )
		 * existingStudent.setId(student2.getId());
		 * existingStudent.setName(student2.getName());
		 * existingStudent.setMobile(student2.getMobile());
		 * existingStudent.setCountry(student2.getCountry());
		 */
		
		model.addAttribute("student", student2);
		
		return "add-student";
		
	}
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id ,Model model ) {
		
		System.out.println(id);
		studentService.deleteStudent(id);
		
		
		
	
		return "redirect:/show";
		
	}
	
	
	
}
