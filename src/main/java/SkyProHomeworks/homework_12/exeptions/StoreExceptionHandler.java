package SkyProHomeworks.homework_12.exeptions;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StoreExceptionHandler
{
    @ExceptionHandler(TypeMismatchException.class)
    public void countOrderIsNotIntException (TypeMismatchException e)
    {
        System.out.println("Пользователь ввел не целочисленное значение!");
    }
}
