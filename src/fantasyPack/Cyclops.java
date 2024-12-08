package fantasyPack;

public class Cyclops extends Creature implements Ability {
    public Cyclops(String name, int age, String habitat) {
        super(name, age, "Cyclops", habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " growls with thunderous might!");
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " smashes boulders with immense strength!");
    }
}
