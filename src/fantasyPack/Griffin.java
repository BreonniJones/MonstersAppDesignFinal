package fantasyPack;

public class Griffin extends Creature implements Ability {
    public Griffin(String name, int age, String habitat) {
        super(name, age, "Griffin", habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " screeches majestically!");
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " soars through the skies and defends treasures!");
    }
}
