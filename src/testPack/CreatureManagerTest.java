package testPack;

import fantasyPack.*;
import fantasyPack.FantasyManager;

public class CreatureManagerTest {
    public static void main(String[] args) {
        FantasyManager manager = new FantasyManager();
        manager.addCreature(new Dragon("Spitfire", 300, "Mountains"));
        manager.addCreature(new Griffin("Ravenclaw", 150, "Forests"));

        manager.displayAllCreatures();

        manager.removeCreature("Spitfire");
        manager.displayAllCreatures();
    }
}
