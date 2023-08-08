package SkyProHomeworks.homework_14;

import SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RequestMapping(path = "/employee")
@RestController
public class EmployeeController
{
    final int noneDepartment = -1;
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam("salary") int salary)
    {
        try
        {
            return employeeService.addEmployee(firstName,lastName,department,salary).toString(true);
        }
        catch (EmployeeAlreadyAddedException e)
        {
            return "EmployeeAlreadyAddedException: Сотрудник уже вбит в список";
        }
    }

    @GetMapping(path = "/delete")
    public String delete (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        try
        {
            return employeeService.deleteEmployee(firstName,lastName).toString(true);
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудник не найден";
        }
    }
    @GetMapping(path = "/changeSalary")
    public String changeSalary (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary")  int salary)
    {
        try
        {
            return employeeService.changeEmployeeSalary(firstName,lastName,salary).toString(true);
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудник не найден";
        }
    }
    @GetMapping(path = "/changeDepartment")
    public String changeDepartment (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department")  int department)
    {
        try
        {
            return employeeService.changeEmployeeDepartment(firstName,lastName,department).toString(true);
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудник не найден";
        }
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAll ()
    {
        return employeeService.printAllEmployee();
    }
    @GetMapping(path = "/index")
    public String getSalaryIndex (@RequestParam("percent")  int percent)
    {
        return employeeService.getEmployeeSalaryIndex(percent);
    }
    @GetMapping(path = "/min-salary")
    public String getMinEmployeeSalary()
    {
        return employeeService.getMinMaxEmployeeSalary(true).toString(true);
    }
    @GetMapping(path = "/max-salary")
    public String getMaxEmployeeSalary()
    {
        return employeeService.getMinMaxEmployeeSalary(false).toString(true);
    }
    @GetMapping(path = "/sum")
    public String getSalarySum()
    {
        return employeeService.getSumEmployeeSalary();
    }
    @GetMapping(path = "/avg")
    public String getSalaryAVG()
    {
        return employeeService.getAVGEmployeeSalary();
    }

}
