package SkyProHomeworks.homework_14;

import SkyProHomeworks.homework_5.exeptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static SkyProHomeworks.homework_14.Constans.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest
{
    private final EmployeeService out = new EmployeeService();


    @Test
    public void addPositiveTest()
    {
        assertEquals(EMPL_1,out.addEmployee("Аркадий","Укупник",1,2000));
    }
    @Test
    public void addAlreadyAddedEmployeeTest()
    {
        out.addEmployee(EMPL_2);
        assertThrows(EmployeeAlreadyAddedException.class,() -> out.addEmployee(EMPL_2));
    }

    @Test
    public void deletePositiveTest()
    {
        out.addEmployee(EMPL_3);
        assertDoesNotThrow(
                () -> out.deleteEmployee(EMPL_3.getFirstName(),EMPL_3.getLastName()));
    }

    @Test
    public void deleteNotFoundEmployeeTest()
    {
        assertThrows(EmployeeNotFoundException.class,
                ()-> out.deleteEmployee(EMPL_3.getFirstName(),EMPL_3.getLastName()));
    }

    @Test
    public void changeEmployeeSalaryPositiveTest()
    {
        int newSalary = 500;
        out.addEmployee(EMPL_4);
        assertDoesNotThrow(()-> out.changeEmployeeSalary(EMPL_4.getFirstName(),EMPL_4.getLastName(),newSalary));
        assertEquals(newSalary,EMPL_4.getSalary());
    }
    @Test
    public void changeEmployeeDepartmentPositiveTest()
    {
        int newDepartment = 14;
        out.addEmployee(EMPL_5);

        assertDoesNotThrow(
                ()-> out.changeEmployeeDepartment(EMPL_5.getFirstName(),EMPL_5.getLastName(),newDepartment));
        assertEquals(newDepartment, EMPL_5.getDepartment());
    }

    @Test
    public void getSalaryIndexPositiveTest()
    {
        int salaryIndex = 10;
        out.addEmployee(EMPL_6);
        int oldSalary = EMPL_6.getSalary();
        out.getEmployeeSalaryIndex(salaryIndex);

        assertEquals((((double) salaryIndex / 100) * oldSalary) + oldSalary, EMPL_6.getSalary());
    }

    @Test
    public void getMinSalaryPositiveTest()
    {
        out.addEmployee(EMPL_7);
        out.addEmployee(EMPL_8);
        assertEquals(EMPL_8.getSalary(), out.getMinMaxEmployeeSalary(true).getSalary());
    }

    @Test
    public void getMaxSalaryPositiveTest()
    {
        out.addEmployee(EMPL_7);
        out.addEmployee(EMPL_8);
        assertEquals(EMPL_7.getSalary(), out.getMinMaxEmployeeSalary(false).getSalary());
    }

    @Test
    public void getSumSalaryTest()
    {
        out.addEmployee(EMPL_1);
        out.addEmployee(EMPL_2);
        out.addEmployee(EMPL_3);
        out.addEmployee(EMPL_4);

        int sum = EMPL_1.getSalary() + EMPL_2.getSalary() + EMPL_3.getSalary() + EMPL_4.getSalary();

        assertEquals(Integer.toString(sum), out.getSumEmployeeSalary());
    }

    @Test
    public void getAVGSalaryTest()
    {
        out.addEmployee(EMPL_5);
        out.addEmployee(EMPL_6);

        double avg = (double) (EMPL_5.getSalary() + EMPL_6.getSalary()) / 2;

        assertEquals(Double.toString(avg), out.getAVGEmployeeSalary());
    }
}
