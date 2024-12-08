package managerPack;

import fantasyPack.*;

import java.util.Scanner;

public class FantasyApp {
    public static void main(String[] args) {
        FantasyManager manager = new FantasyManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Creature");
            System.out.println("2. Remove Creature");
            System.out.println("3. Display Creatures");
            System.out.println("4. Execute Abilities");
            System.out.println("5. Exit");

            switch (scanner.nextInt()) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter creature name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter habitat: ");
                    String habitat = scanner.nextLine();
                    System.out.println("Enter type (Dragon, Griffin, Centaur, Cyclops, Serpent): ");
                    String type = scanner.nextLine();

                    switch (type.toLowerCase()) {
                        case "dragon" -> manager.addCreature(new Dragon(name, age, habitat));
                        case "griffin" -> manager.addCreature(new Griffin(name, age, habitat));
                        case "centaur" -> manager.addCreature(new Centaur(name, age, habitat));
                        case "cyclops" -> manager.addCreature(new Cyclops(name, age, habitat));
                        case "serpent" -> manager.addCreature(new Serpent(name, age, habitat));
                        default -> System.out.println("Invalid type!");
                    }
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter creature name to remove: ");
                    manager.removeCreature(scanner.nextLine());
                    break;
                case 3:
                    manager.displayAllCreatures();
                    break;
                case 4:
                    System.out.println("\nExecuting Abilities of All Creatures:");
                    for (Creature creature : manager.getCreatures()) {
                        System.out.println("\n" + creature.getName() + ":");
                        creature.makeSound();
                        if (creature instanceof Ability) {
                            ((Ability) creature).executeAbility();
                        }

                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}
