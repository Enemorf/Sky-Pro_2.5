package part5.SkyProHomeworks.homework_8;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentService
{
    private Map<String, Employee> employeeMap;

    public DepartmentService (EmployeeService employeeService)
    {
        //this.employeeService = employeeService;
        this.employeeMap = employeeService.getEmployeeMap();
    }

    public List<Employee> printAllInDepartment (int department)
    {
        return employeeMap.values().stream()
                .filter(dep -> dep.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> printAllEmployee()
    {
        Map<Integer,List<Employee>> sortMap = new HashMap<>();

        employeeMap.values().forEach(
                empl -> sortMap.merge(empl.getDepartment(), Collections.singletonList(empl),
                        (prev, one) ->
                        {
                            List<Employee> e = new ArrayList<>(prev);
                            e.addAll(one);
                            return e;
                        })
        );
        return sortMap;
    }

    public Employee getMinMaxEmployeeSalaryInDepartment (boolean isMin, int department)
    {
        if(isMin)
            return   employeeMap.values().stream()
                .filter(empl -> empl.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .get();
        else
            return   employeeMap.values().stream()
                    .filter(empl -> empl.getDepartment() == department)
                    .max(Comparator.comparingInt(Employee::getSalary))
                    .get();
    }

    public String getEmployeeSalaryIndexInDepartment (int department, int percent)
    {
        employeeMap.values().stream()
                .filter(empl -> empl.getDepartment() == department)
                .forEach(empl -> empl.setSalary((int)(((double) percent / 100) * empl.getSalary()) + empl.getSalary()));
        return employeeMap.values().toString();
    }

    public String getSumEmployeeSalaryInDepartment (int department)
    {
        return String.valueOf(employeeMap.values().stream()
                .filter(empl -> empl.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum());
    }

    public String getAVGEmployeeSalaryInDepartment (int department)
    {
        return String.valueOf(employeeMap.values().stream()
                .filter(empl -> empl.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average().getAsDouble());
    }
}
