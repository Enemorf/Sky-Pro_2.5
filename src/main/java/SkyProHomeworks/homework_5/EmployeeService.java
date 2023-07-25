package SkyProHomeworks.homework_5;

import org.springframework.stereotype.Service;
import SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;
import SkyProHomeworks.homework_5.exeptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService
{
    private final int maxEmployee = 10;
    private List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee (String firstName, String lastName)
    {
        if(employeeList.size() == maxEmployee)
            throw new EmployeeStorageIsFullException();
        Employee employee = new Employee(firstName,lastName);

        if(employeeList.contains(employee))
            throw new EmployeeAlreadyAddedException();

        employeeList.add(employee);
        return employee;
    }

    public Employee deleteEmployee (String firstName, String lastName)
    {
        Employee employee = new Employee(firstName, lastName);

        if(!employeeList.contains(employee))
            throw new EmployeeNotFoundException();

        employeeList.remove(employee);
        return employee;
    }

    public Employee searchEmployee (String firstName, String lastName)
    {
        Employee employee = new Employee(firstName, lastName);

        if(!employeeList.contains(employee))
            throw new EmployeeNotFoundException();
        return employee;
    }

    public String printAll ()
    {
        return employeeList.toString();
    }

}