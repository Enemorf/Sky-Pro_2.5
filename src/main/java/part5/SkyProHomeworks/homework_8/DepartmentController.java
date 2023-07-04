package part5.SkyProHomeworks.homework_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/departments")
@RestController
public class DepartmentController
{
    private final MainService mainService;
    public DepartmentController (MainService mainService)
    {
        this.mainService = mainService;
    }

    @GetMapping(path = "/all")
    public String printAll(@RequestParam("departmentId") int department)
    {
        return mainService.printAllEmployee(department);
    }

    @GetMapping(path = "/min-salary")
    public String getMinSalary(@RequestParam("departmentId") int department)
    {
        return mainService.getMinMaxEmployeeSalary(true,department).toString(false);
    }

    @GetMapping(path = "/max-salary")
    public String getMaxSalary(@RequestParam("departmentId") int department)
    {
        return mainService.getMinMaxEmployeeSalary(false,department).toString(false);
    }
    @GetMapping(path = "/index")
    public String getSalaryIndex(@RequestParam("departmentId") int department, @RequestParam("percent") int percent)
    {
        return mainService.getEmployeeSalaryIndex(department,percent);
    }

    @GetMapping(path = "/sum")
    public String getSalarySum (@RequestParam("departmentId") int department)
    {
        return mainService.getSumEmployeeSalary(department);
    }

    @GetMapping(path = "/avg")
    public String getSalaryAVG(@RequestParam("departmentId") int department)
    {
        return mainService.getAVGEmployeeSalary(department);
    }

}
