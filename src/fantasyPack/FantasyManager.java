package fantasyPack;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FantasyManager {
    private List<Creature> creatures = new ArrayList<>();
    private final String DATA_FILE = "creatures.dat";

    // Constructor to load data on initialization
    public FantasyManager() {
        loadCreaturesFromFile();
    }

    // Add a new creature
    public void addCreature(Creature creature) {
        creatures.add(creature);
        System.out.println("Creature added successfully: " + creature.getName());
        saveCreaturesToFile();
    }

    // Display all creatures
    public void displayAllCreatures() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures to display.");
            return;
        }

        System.out.println("List of Creatures:");
        for (Creature creature : creatures) {
            System.out.println(creature);
        }
    }

    // Return the list of creatures
    public List<Creature> getCreatures() {
        return creatures;
    }

    // Modify a creature's details
    public void modifyCreature(String name) {
        for (Creature creature : creatures) {
            if (creature.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new name: ");
                creature.setName(scanner.nextLine());
                System.out.print("Enter new age: ");
                creature.setAge(scanner.nextInt());
                scanner.nextLine(); 
                System.out.print("Enter new habitat: ");
                creature.setHabitat(scanner.nextLine());
                System.out.println("Creature updated successfully.");
                saveCreaturesToFile();
                return;
            }
        }
        System.out.println("No creature found with the name: " + name);
    }

    // Remove a creature
    public void removeCreature(String name) {
        Iterator<Creature> iterator = creatures.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Creature removed successfully.");
                saveCreaturesToFile();
                return;
            }
        }
        System.out.println("No creature found with the name: " + name);
    }

    // Execute a creature's ability
    public void performCreatureAbility(String name) {
        for (Creature creature : creatures) {
            if (creature.getName().equalsIgnoreCase(name) && creature instanceof Ability) {
                ((Ability) creature).executeAbility();
                return;
            }
        }
        System.out.println("No creature found with that name or it has no special abilities.");
    }

    // Filter creatures by type
    public void filterByType(String type) {
        List<Creature> filtered = creatures.stream()
                                           .filter(c -> c.getType().equalsIgnoreCase(type))
                                           .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No creatures found of type: " + type);
        } else {
            System.out.println("Creatures of type " + type + ":");
            filtered.forEach(System.out::println);
        }
    }

    // Display statistical analysis
    public void displayStatistics() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures available for statistical analysis.");
            return;
        }

        double avgAge = creatures.stream().mapToInt(Creature::getAge).average().orElse(0);
        System.out.println("Average age of creatures: " + avgAge);

        Map<String, Long> typeDistribution = creatures.stream()
                                                      .collect(Collectors.groupingBy(Creature::getType, Collectors.counting()));
        System.out.println("Type distribution:");
        typeDistribution.forEach((type, count) -> System.out.println(type + ": " + count));
    }

    // Save creatures to file
    private void saveCreaturesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(creatures);
        } catch (IOException e) {
            System.err.println("Error saving creatures to file: " + e.getMessage());
        }
    }

    // Load creatures from file
    private void loadCreaturesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            creatures = (List<Creature>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting with an empty collection.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading creatures from file: " + e.getMessage());
        }
    }
}
