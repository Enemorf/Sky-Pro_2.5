package SkyProHomeworks.homework_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/departments")
@RestController
public class DepartmentController
{
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @RequestMapping(path = "/all", params = "departmentId")
    public List<Employee> printAll(@RequestParam("departmentId") int department)
    {
        return departmentService.printAllInDepartment(department);
    }

    @RequestMapping(path = "/all")
    public Map<Integer, List<Employee>> printAll ()
    {
        return departmentService.printAllEmployee();
    }

    @GetMapping(path = "/min-salary")
    public String getMinSalary(@RequestParam("departmentId") int department)
    {
        return departmentService.getMinMaxEmployeeSalaryInDepartment(true,department).toString(false);
    }

    @GetMapping(path = "/max-salary")
    public String getMaxSalary(@RequestParam("departmentId") int department)
    {
        return departmentService.getMinMaxEmployeeSalaryInDepartment(false,department).toString(false);
    }
    @GetMapping(path = "/index")
    public String getSalaryIndex(@RequestParam("departmentId") int department, @RequestParam("percent") int percent)
    {
        return departmentService.getEmployeeSalaryIndexInDepartment(department,percent);
    }

    @GetMapping(path = "/sum")
    public String getSalarySum (@RequestParam("departmentId") int department)
    {
        return departmentService.getSumEmployeeSalaryInDepartment(department);
    }

    @GetMapping(path = "/avg")
    public String getSalaryAVG(@RequestParam("departmentId") int department)
    {
        return departmentService.getAVGEmployeeSalaryInDepartment(department);
    }

}
