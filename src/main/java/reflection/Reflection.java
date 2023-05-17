package reflection;

import people.Student;

import java.lang.reflect.*;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) {
        Class<?> studentClass = Student.class;
        printConstructors(studentClass);
        printMethods(studentClass);
        printFields(studentClass);
    }

    public static void printConstructors(Class<?> className) {
        Constructor<?>[] constructors = className.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("Constructor: " + c.getName() + "\n" +
                    "Number of parameters: " + c.getParameterCount() + "\n" +
                    "Modifiers: " + Modifier.toString(c.getModifiers()));
        }
    }

    public static void printMethods(Class<?> className) {
        Method[] methods = className.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + "\n" +
                    "Return type: " + m.getReturnType() + "\n" +
                    "Number of parameters: " + m.getParameterCount() + "\n" +
                    "Modifiers: " + Modifier.toString(m.getModifiers()));
        }
    }

    public static void printFields(Class<?> className) {
        Field[] fields = className.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("Field: " + f.getName() + "\n" +
                               "Type: " +  f.getType() + "\n" +
                               "Modifiers: " + Modifier.toString(f.getModifiers()));
        }
    }
}