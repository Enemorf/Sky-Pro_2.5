package SkyProHomeworks.homework_8;

import SkyProHomeworks.homework_5.exeptions.InvalidInputExeprion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;

import java.util.*;


@Service
public class EmployeeService
{
    private Map<String, Employee> employeeMap = new HashMap<>();

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public Employee addEmployee (String firstName, String lastName, int department, int salary)
    {
        if(employeeMap.containsKey(firstName+lastName))
            throw new EmployeeAlreadyAddedException();

        if(input(firstName, lastName))
            throw new InvalidInputExeprion();

        Employee employee = new Employee(firstName,lastName,department,salary);
        employeeMap.put(firstName + lastName, employee);
        return employee;
    }

    public Employee deleteEmployee (String firstName, String lastName)
    {
        if(!employeeMap.containsKey(firstName+lastName))
            throw new EmployeeNotFoundException();

        if(input(firstName, lastName))
            throw new InvalidInputExeprion();

        return employeeMap.remove(firstName+lastName);
    }

    public Employee changeEmployeeSalary (String firstName, String lastName, int salary)
    {
         if(!employeeMap.containsKey(firstName+lastName))
             throw new EmployeeNotFoundException();

        if(input(firstName, lastName))
            throw new InvalidInputExeprion();

         Employee employee = employeeMap.get(firstName+lastName);
         employee.setSalary(salary);
         employeeMap.replace(firstName+lastName, employee);
         return employee;
    }

    public Employee changeEmployeeDepartment (String firstName, String lastName, int department)
    {
        if(!employeeMap.containsKey(firstName+lastName))
            throw new EmployeeNotFoundException();

        if(input(firstName, lastName))
            throw new InvalidInputExeprion();

        Employee employee = employeeMap.get(firstName+lastName);
        employee.setDepartment(department);
        employeeMap.replace(firstName+lastName, employee);
        return employee;
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

   public String getEmployeeSalaryIndex (int percent)
   {
           employeeMap.values().forEach(
                   empl -> empl.setSalary((int)(((double) percent / 100) * empl.getSalary()) + empl.getSalary()));
           return printAllEmployee().values().toString();

   }

   public Employee getMinMaxEmployeeSalary (boolean isMin)
   {
       if(isMin)
           return   employeeMap.values().stream()
                   .min(Comparator.comparingInt(Employee::getSalary))
                   .get();
       else
               return   employeeMap.values().stream()
                       .max(Comparator.comparingInt(Employee::getSalary))
                       .get();
   }

   public String getSumEmployeeSalary ()
   {
           return String.valueOf(employeeMap.values().stream()
                   .mapToInt(Employee::getSalary)
                   .sum());
   }

   public String getAVGEmployeeSalary ()
   {
           return String.valueOf( employeeMap.values().stream()
               .mapToInt(Employee::getSalary)
               .average().getAsDouble());
   }

   private boolean input (String firstName, String lastName)
   {
       return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
   }
}
