public class Employee {
    private String name;
    private int age;
    private double salary;

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter methods for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        Employee employee = new Employee();

        // Setting values using setter methods
        employee.setName("John Doe");
        employee.setAge(30);
        employee.setSalary(50000.0);

        // Getting values using getter methods
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: $" + employee.getSalary());
    }
}