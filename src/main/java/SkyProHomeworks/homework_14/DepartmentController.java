package SkyProHomeworks.homework_14;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/department")
@RestController
public class DepartmentController
{
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employees")
    public Map<Integer,List<Employee>> printAll()
    {
        return departmentService.printAllEmployee();
    }

    @GetMapping(path = "/{id}/salary/sum")
    public String getSalarySum(@PathVariable("id") int department)
    {
        return departmentService.getSumEmployeeSalaryInDepartment(department);
    }

    @GetMapping(path = "/{id}/salary/max")
    public String getMaxSalary(@PathVariable("id") int department)
    {
        return departmentService.getMinMaxEmployeeSalaryInDepartment(false,department).toString(false);
    }

    @GetMapping(path = "/{id}/salary/min")
    public String getMinSalary(@PathVariable("id") int department)
    {
        return departmentService.getMinMaxEmployeeSalaryInDepartment(true,department).toString(false);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> printAllInDepartment(@PathVariable("id") int department)
    {
        return departmentService.printAllInDepartment(department);
    }
}
