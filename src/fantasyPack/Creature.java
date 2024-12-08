package fantasyPack;

import java.io.Serializable;

public abstract class Creature implements Serializable, Ability {
    private String name;
    private int age;
    private String type;
    private String habitat;

    // Constructor with parameters
    public Creature(String name, int age, String type, String habitat) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.habitat = habitat;
    }

    // Default constructor (optional)
    public Creature() {}

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }

    // Abstract method for sound
    public abstract void makeSound();

    // Implement the executeAbility() method from the Ability interface
    @Override
    public abstract void executeAbility();

    // Override toString() for formatted creature display
    @Override
    public String toString() {
        return String.format("Name: %s | Age: %d | Type: %s | Habitat: %s", name, age, type, habitat);
    }
}
