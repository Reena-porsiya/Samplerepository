abstract class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void sound();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    public void sound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    public void sound() {
        System.out.println("Meow!");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        System.out.println("Dog name: " + dog.getName());
        dog.sound();
        
        System.out.println("Cat name: " + cat.getName());
        cat.sound();
    }
}