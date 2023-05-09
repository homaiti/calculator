package pro.sky.java.course2.listSets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.listSets.Employee;
import pro.sky.java.course2.listSets.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return service.addEmpl(firstName, lastName);
    }

    @GetMapping("/search")
    public Employee search(@RequestParam String firstName, @RequestParam String lastName) {
        return service.serachEmpl(firstName, lastName);
    }
    @GetMapping("/delete")
    public Employee delete(@RequestParam String firstName, @RequestParam String lastName) {
        return service.delEmpl(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> delete()
    {
        return service.getEmplList();
    }
}
