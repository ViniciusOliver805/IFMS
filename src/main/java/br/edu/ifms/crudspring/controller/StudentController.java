package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Student;
import br.edu.ifms.crudspring.services.StudentService;

@Controller
@RequestMapping("/")

public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String novaPagina2() {
        return "siteifms";
    }
    @GetMapping("/final")
    public String localizatodos(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students); 
        return "final.html";
    }
    @GetMapping("/final2")
    public String localizatodos2(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students); 
        return "final2.html";
    }



    @PostMapping ("/student")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/";
    }

    @GetMapping("/student")
    public String locAll(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "tela_cadastro";
    }

    @GetMapping("/cadastrar")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "cadastrar";


    }
    @GetMapping("/cursoescolha")
    public String novaPagina() {
        return "cursoescolha";
    }

    
    @GetMapping("/remove/{id}")
  public String deleteStudent(@PathVariable("id") UUID id)
  {
      studentService.deleteById(id);
      return "redirect:/student/";
      
  }
// para chamar a pagina de edit-student.html
 @GetMapping("/edit/{id}")
 public String editStudent (@PathVariable("id") UUID id, Model model){
     Student student = studentService.findById(id);
     model.addAttribute("student", student);
     return "edit-student";
 } 

 //aqui chama a função para dar uptade no aluno vulgo editar
 @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Student student){
        studentService.save(student);

        return "redirect:/student/";
 
    }
}