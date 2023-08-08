package SkyProHomeworks.homework_14;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constans {
    public static final Employee EMPL_1 = new Employee("Аркадий","Укупник",1,2000);
    public static final Employee EMPL_2 = new Employee("Александр","Невский",2,615);
    public static final Employee EMPL_3 = new Employee("Вячеслав","Зайцев",3,78444);
    public static final Employee EMPL_4 = new Employee("Федор","Емельянов",4,20);
    public static final Employee EMPL_5 = new Employee("Светлана","Лобода",1,3450);
    public static final Employee EMPL_6 = new Employee("Саша","Бортич",2,980);
    public static final Employee EMPL_7 = new Employee("Коко","Шанель",3,98500);
    public static final Employee EMPL_8 = new Employee("Ирина","Успенская",4,13);
    public final static Map<String,Employee> ALL_EMPL = Map.of(
            EMPL_1.getFirstName() + EMPL_1.getLastName(), EMPL_1,
            EMPL_2.getFirstName() + EMPL_2.getLastName(), EMPL_2,
            EMPL_3.getFirstName() + EMPL_3.getLastName(), EMPL_3,
            EMPL_4.getFirstName() + EMPL_4.getLastName(), EMPL_4,
            EMPL_5.getFirstName() + EMPL_5.getLastName(), EMPL_5,
            EMPL_6.getFirstName() + EMPL_6.getLastName(), EMPL_6,
            EMPL_7.getFirstName() + EMPL_7.getLastName(), EMPL_7,
            EMPL_8.getFirstName() + EMPL_8.getLastName(), EMPL_8);
}
