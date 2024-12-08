package fantasyPack;

public class Centaur extends Creature implements Ability {
    public Centaur(String name, int age, String habitat) {
        super(name, age, "Centaur", habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " neighs with wisdom and strength!");
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " gallops swiftly and strikes with precision!");
    }
}
