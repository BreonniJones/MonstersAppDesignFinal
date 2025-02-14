package utilPack;

public class Validation {
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static boolean isValidHabitat(String habitat) {
        return habitat != null && !habitat.trim().isEmpty();
    }
}
