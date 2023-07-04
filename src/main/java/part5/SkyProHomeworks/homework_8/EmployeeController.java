package part5.SkyProHomeworks.homework_8;

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
    final int noneDepartment = -1;
    private final MainService mainService;
    public EmployeeController (MainService mainService)
    {
        this.mainService = mainService;
    }

    @GetMapping(path = "/add")
    public String add (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam("salary") int salary)
    {
        try
        {
            return mainService.addEmployee(firstName,lastName,department,salary).toString(true);
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
            return mainService.deleteEmployee(firstName,lastName).toString(true);
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
            return mainService.changeEmployeeSalary(firstName,lastName,salary).toString(true);
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
            return mainService.changeEmployeeDepartment(firstName,lastName,department).toString(true);
        }
        catch (EmployeeNotFoundException e)
        {
            return "EmployeeNotFoundException: Сотрудник не найден";
        }
    }
    @GetMapping(path = "/all")
    public String printAll ()
    {
        return mainService.printAllEmployee(noneDepartment);
    }
    @GetMapping(path = "/index")
    public String getSalaryIndex (@RequestParam("percent")  int percent)
    {
        return mainService.getEmployeeSalaryIndex(noneDepartment,percent);
    }
    @GetMapping(path = "/min-salary")
    public String getMinEmployeeSalary()
    {
        return mainService.getMinMaxEmployeeSalary(true,noneDepartment).toString(true);
    }
    @GetMapping(path = "/max-salary")
    public String getMaxEmployeeSalary()
    {
        return mainService.getMinMaxEmployeeSalary(false,noneDepartment).toString(true);
    }
    @GetMapping(path = "/sum")
    public String getSalarySum()
    {
        return mainService.getSumEmployeeSalary(noneDepartment);
    }
    @GetMapping(path = "/avg")
    public String getSalaryAVG()
    {
        return mainService.getAVGEmployeeSalary(noneDepartment);
    }

}
