package part5.SkyProHomeworks.homework_5;

import org.springframework.stereotype.Service;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeAlreadyAddedException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeNotFoundException;
import part5.SkyProHomeworks.homework_5.exeptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService
{
    private Map<String,Employee> employeeMap = new HashMap<>();
    String checkName;

    public Employee addEmployee (String firstName, String lastName)
    {
        checkName = firstName+lastName;

        if(employeeMap.containsKey(checkName))
            throw new EmployeeAlreadyAddedException();

        Employee employee = new Employee(firstName,lastName);

        employeeMap.put(checkName,employee);

        return employee;
    }

    public Employee deleteEmployee (String firstName, String lastName)
    {
        checkName = firstName+lastName;

        if(!employeeMap.containsKey(checkName))
            throw new EmployeeNotFoundException();

        return employeeMap.remove(checkName);
    }

    public Employee searchEmployee (String firstName, String lastName)
    {
        checkName = firstName+lastName;

        if(!employeeMap.containsKey(checkName))
            throw new EmployeeNotFoundException();

        return employeeMap.get(checkName);
    }

    public String printAll ()
    {
        return employeeMap.values().toString();
    }

}
