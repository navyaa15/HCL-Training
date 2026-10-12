
package Task2;
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name
                + ", Salary: " + salary;
    }
}

public class employee {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103, "Rahul", 30000));
        employees.add(new Employee(101, "Aman", 25000));
        employees.add(new Employee(102, "Priya", 35000));

        System.out.println("All Employees:");
        System.out.println(employees);

        // READ using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // UPDATE employee salary
        for (Employee e : employees) {
            if (e.id == 101) {
                e.salary = 40000;
            }
        }

        System.out.println("\nAfter Update:");
        System.out.println(employees);


        Iterator<Employee> itr = employees.iterator();

        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.id == 103) {
                itr.remove();
            }
        }

        System.out.println("\nAfter Delete:");
        System.out.println(employees);

        // ListIterator: forward traversal
        System.out.println("\nListIterator Forward:");
        ListIterator<Employee> li = employees.listIterator();

        while (li.hasNext()) {
            System.out.println(li.next());
        }

        // ListIterator: backward traversal
        System.out.println("\nListIterator Backward:");

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }

        // Ascending order by employee ID
        employees.sort(Comparator.comparingInt(e -> e.id));

        System.out.println("\nAscending Order by ID:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Descending order by employee ID
        employees.sort(
                Comparator.comparingInt((Employee e) -> e.id).reversed()
        );

        System.out.println("\nDescending Order by ID:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
