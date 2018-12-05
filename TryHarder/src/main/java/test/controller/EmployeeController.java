package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import test.model.Employee;
import test.service.EmployeeService;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @RequestMapping(value = "/")
    public String getAllEmployee(Model model){
        List<Employee> listEmp = employeeService.getAllEmployee();
        model.addAttribute("listEmp", listEmp);
        return "list";
    }

    public Employee getEmployeeById(Integer empId){
        return employeeService.getEmployeeById(empId);
    }

    public void updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
    }

    public void deleteEmployee(Integer empId){
        employeeService.deleteEmployee(empId);
    }
}
