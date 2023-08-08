package SkyProHomeworks.homework_14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static SkyProHomeworks.homework_14.Constans.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest
{
    @Mock
    private EmployeeService employeeServiceMock;

    private DepartmentService out;

    @BeforeEach
    public void before()
    {
        when(employeeServiceMock.getEmployeeMap()).thenReturn(ALL_EMPL);
        out = new DepartmentService(employeeServiceMock);
    }

    @Test
    public void departNotFoundTest()
    {
        assertIterableEquals(new ArrayList<>(), out.printAllInDepartment(8));
    }

    @Test
    public void departFoundTest()
    {
        List<Employee> first = new ArrayList<>(List.of(EMPL_1,EMPL_5));
        List<Employee> expected = out.printAllInDepartment(1);
        assertIterableEquals(first,expected);
    }


    @Test
    public void printAllEmployeeTest()
    {
        Map<Integer,List<Employee>> tempList = new TreeMap<>(Map.of(
                1,new ArrayList<>(List.of(EMPL_1,EMPL_5)),
                2,new ArrayList<>(List.of(EMPL_2,EMPL_6)),
                3,new ArrayList<>(List.of(EMPL_3,EMPL_7)),
                4,new ArrayList<>(List.of(EMPL_8,EMPL_4))
        ));

        Map<Integer,List<Employee>> second = out.printAllEmployee();

        assertIterableEquals(Collections.singleton(tempList), Collections.singleton(second));
    }

    @Test
    public void getMaxSalaryInDepartTest()
    {
        assertEquals(EMPL_6, out.getMinMaxEmployeeSalaryInDepartment(false,2));
    }

    @Test
    public void getMinSalaryInDepartTest()
    {
        assertEquals(EMPL_1, out.getMinMaxEmployeeSalaryInDepartment(true,1));
    }

    @Test
    public void getSumSalaryInDepartmentTest() {
        int sum = EMPL_3.getSalary() + EMPL_7.getSalary();
        assertEquals(Integer.toString(sum), out.getSumEmployeeSalaryInDepartment(3));
    }

    @Test
    public void getAVGSalaryInDepartmentTest()
    {
        double avg = (double) (EMPL_4.getSalary() + EMPL_8.getSalary()) /2;
        assertEquals(Double.toString(avg), out.getAVGEmployeeSalaryInDepartment(4));
    }

    @Test
    public void getIndexSalaryInDepartmentTest()
    {
        int percent = 10;
        int newSalary1 = (int)(((double) percent / 100) * EMPL_1.getSalary()) + EMPL_1.getSalary();
        int newSalary5 = (int)(((double) percent / 100) * EMPL_5.getSalary()) + EMPL_5.getSalary();
        out.getEmployeeSalaryIndexInDepartment(1,percent);

        assertEquals(newSalary1, EMPL_1.getSalary());
        assertEquals(newSalary5, EMPL_5.getSalary());
    }







}
