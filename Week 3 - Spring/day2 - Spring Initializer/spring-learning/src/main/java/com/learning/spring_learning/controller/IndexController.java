package com.learning.spring_learning.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring_learning.model.Employee;


@Controller
@RequestMapping("index")
public class IndexController {
  
  @GetMapping("/")
  public String getHelloWorld(Model model) {
      model.addAttribute("name", "Ali");
      return "index";
  }

  @GetMapping("/employee")
  public String getEmployee(Model model) {
    Employee emp1 = new Employee("Andi", LocalDate.of(2025,2,4), 2_000_000);
    Employee emp2 = new Employee("Andini", LocalDate.of(2025,8,12), 1_500_000);

    var employees = List.of(emp1, emp2);

    model.addAttribute("employees", employees);

    return "employee";
  }
  
  
}
