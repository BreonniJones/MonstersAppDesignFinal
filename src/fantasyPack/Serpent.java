package fantasyPack;

public class Serpent extends Creature implements Ability {
    public Serpent(String name, int age, String habitat) {
        super(name, age, "Serpent", habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " hisses ominously!");
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " slithers silently and hypnotizes prey!");
    }
}
