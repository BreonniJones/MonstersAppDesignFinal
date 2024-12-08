package fantasyPack;

public class Dragon extends Creature implements Ability {
    public Dragon(String name, int age, String habitat) {
        super(name, age, "Dragon", habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars with fiery breath!");
    }

    @Override
    public void executeAbility() {
        System.out.println(getName() + " breathes fire and flies over mountains!");
    }
}
