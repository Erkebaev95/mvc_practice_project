package com.nursultan.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "firstView";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

        /*Employee emp = new Employee();
        emp.setName("Ivan");
        emp.setSurName("Petrov");
        emp.setSalary(500);*/
        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    // first way
    /*@RequestMapping("/showDetails")
    public String showEmpDetails() {
        return "show-emp-details-view";
    }*/

    // first way
    /*@RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest request, Model model) {

        String empName = request.getParameter("employeeName");
        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);

        model.addAttribute("description", " - udemy instructor");

        return "show-emp-details-view";
    }*/

    // first way
    /*@RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model) {

        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);

        return "show-emp-details-view";
    }*/

    //
    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) {

        String name = emp.getName();
        emp.setName("Mr. " + name);

        String surname = emp.getSurName();
        emp.setSurName(surname + "!");

        int salary = emp.getSalary();
        emp.setSalary(salary * 10);

        return "show-emp-details-view";
    }
}
