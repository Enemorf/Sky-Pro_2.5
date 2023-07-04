package part5.SkyProHomeworks.homework_8;

import org.springframework.stereotype.Service;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MainService
{
    private Map<String, Employee> employeeMap = new HashMap<>();


    public Employee addEmployee (String firstName, String lastName, int department, int salary)
    {
        if(employeeMap.containsKey(firstName+lastName))
            throw new EmployeeAlreadyAddedException();

        Employee employee = new Employee(firstName,lastName,department,salary);
        employeeMap.put(firstName + lastName, employee);
        return employee;
    }

    public Employee deleteEmployee (String firstName, String lastName)
    {
        if(!employeeMap.containsKey(firstName+lastName))
            throw new EmployeeNotFoundException();

        return employeeMap.remove(firstName+lastName);
    }

    public Employee changeEmployeeSalary (String firstName, String lastName, int salary)
    {
         if(!employeeMap.containsKey(firstName+lastName))
             throw new EmployeeNotFoundException();

         Employee employee = employeeMap.get(firstName+lastName);
         employee.setSalary(salary);
         employeeMap.replace(firstName+lastName, employee);
         return employee;
    }

    public Employee changeEmployeeDepartment (String firstName, String lastName, int department)
    {
        if(!employeeMap.containsKey(firstName+lastName))
            throw new EmployeeNotFoundException();

        Employee employee = employeeMap.get(firstName+lastName);
        employee.setDepartment(department);
        employeeMap.replace(firstName+lastName, employee);
        return employee;
    }

    public String printAllEmployee(int department)
    {
        if(department == -1)
        {
            Map<Integer,String> sortMap = new HashMap<>();
            employeeMap.values().forEach( empl ->
                sortMap.merge(empl.getDepartment(),empl.toString(false), (prev, one) -> prev +"," + one));
            return String.valueOf(sortMap);
        }
        else
        {
            return String.valueOf(employeeMap.values().stream()
                    .filter(dep -> dep.getDepartment() == department)
                    .map(empl -> empl.toString(false))
                    .collect(Collectors.toList()));
        }
    }

   public String getEmployeeSalaryIndex (int department, int percent)
   {
       if(department == -1)
       {
           employeeMap.values().forEach(
                   empl -> empl.setSalary((int)(((double) percent / 100) * empl.getSalary()) + empl.getSalary()));
           return printAllEmployee(-1);
       }
       else
       {
           employeeMap.values().stream()
                   .filter(empl -> empl.getDepartment() == department)
                   .forEach(empl -> empl.setSalary((int)(((double) percent / 100) * empl.getSalary()) + empl.getSalary()));
           return printAllEmployee(department);
       }
   }

   public Employee getMinMaxEmployeeSalary (boolean isMin, int department)
   {
       if(isMin)
       {
           if(department == -1)
               return   employeeMap.values().stream()
                       .min(Comparator.comparingInt(Employee::getSalary))
                       .get();
           else
               return   employeeMap.values().stream()
                       .filter(empl -> empl.getDepartment() == department)
                       .min(Comparator.comparingInt(Employee::getSalary))
                       .get();
       }
       else
       {
           if(department == -1)
               return   employeeMap.values().stream()
                       .max(Comparator.comparingInt(Employee::getSalary))
                       .get();
           else
               return   employeeMap.values().stream()
                       .filter(empl -> empl.getDepartment() == department)
                       .max(Comparator.comparingInt(Employee::getSalary))
                       .get();
       }
   }

   public String getSumEmployeeSalary (int department)
   {
       if(department == -1)
           return String.valueOf(employeeMap.values().stream()
                   .mapToInt(Employee::getSalary)
                   .sum());
       else
           return String.valueOf(employeeMap.values().stream()
                   .filter(empl -> empl.getDepartment() == department)
                   .mapToInt(Employee::getSalary)
                   .sum());
   }

   public String getAVGEmployeeSalary (int department)
   {
       if(department == -1)
           return String.valueOf( employeeMap.values().stream()
               .mapToInt(Employee::getSalary)
               .average().getAsDouble());
       else
           return String.valueOf(employeeMap.values().stream()
                   .filter(empl -> empl.getDepartment() == department)
                   .mapToInt(Employee::getSalary)
                   .average().getAsDouble());
   }
}
