package part5.SkyProHomeworks.homework_5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeStorageIsFullException;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        try
        {
           return employeeService.addEmployee(firstName,lastName).toString();
        }
        catch (EmployeeStorageIsFullException e)
        {
            return "EmployeeStorageIsFullException: Список сотрудников переполнен";
        }
        catch (EmployeeAlreadyAddedException e)
        {
            return "EmployeeAlreadyAddedException: Сотрудник уже вбит в список";
        }
    }

    @GetMapping(path = "/remove")
    public String remove (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        try
        {
            return employeeService.deleteEmployee(firstName,lastName).toString();
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудника не существует";
        }
    }

    @GetMapping(path = "/find")
    public String find (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        try
        {
            return employeeService.searchEmployee(firstName,lastName).toString();
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудника не существует";
        }
    }

    @GetMapping(path = "/printAll")
    public String printAll()
    {
        return employeeService.printAll();
    }
}
