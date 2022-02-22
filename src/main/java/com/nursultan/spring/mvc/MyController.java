package com.nursultan.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    // simple way
    /*@RequestMapping("/showDetails")
    public String showEmpDetails() {
        return "show-emp-details-view";
    }*/

    // hard coded way
    /*@RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest request, Model model) {

        String empName = request.getParameter("employeeName");
        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);

        model.addAttribute("description", " - udemy instructor");

        return "show-emp-details-view";
    }*/

    // we use RequestParam and Model
    /*@RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model) {

        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);

        return "show-emp-details-view";
    }*/

    // we use ModelAttribute and Employee
    /*@RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) {

        return "show-emp-details-view";
    }*/

    // setup checking by name
    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        }
        else {
            return "show-emp-details-view";
        }
    }
}
