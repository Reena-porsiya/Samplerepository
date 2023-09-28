public class Employee {
    private String name;
    private int age;
    private double salary;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(30);
        employee.setSalary(50000.0);
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: $" + employee.getSalary());
    }
}