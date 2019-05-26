package javaConstructs;

<<<<<<< HEAD
/**
 * Created by amthukra on 1/10/2019.
 */
public class CustomSorter {
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by amthukra on 1/10/2019.
 */

class Employee {
    int id;
    int salary;
    String name;

    Employee(int id, int salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public void printEmployeeList(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.print(employees.get(i).id + " ");
            System.out.print(employees.get(i).salary + " ");
            System.out.println(employees.get(i).name);
        }
        System.out.println("---------Print End ---------- ");
    }
}

class SortBySalary implements Comparator<Employee> {

    public int compare(Employee one, Employee two) {
        return one.salary - two.salary;
    }
}

class SortByName implements Comparator<Employee> {

    public int compare(Employee one, Employee two) {
        return one.name.charAt(0) - two.name.charAt(0);
    }
}


public class CustomSorter {


    public static void main(String[] args) {
        Employee geeta = new Employee(3, 370, "Geeta");
        Employee ram = new Employee(1, 100, "Ram");
        Employee shyam = new Employee(2, 250, "Shyam");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(geeta);
        employees.add(shyam);
        employees.add(ram);


        geeta.printEmployeeList(employees);

        // Sort list by salary
        SortBySalary sortBySalary = new SortBySalary();
        Collections.sort(employees, sortBySalary);
        geeta.printEmployeeList(employees);

        // Sort list by first character of name
        SortByName sortByName = new SortByName();
        Collections.sort(employees, sortByName);
        geeta.printEmployeeList(employees);
    }
>>>>>>> master
}
