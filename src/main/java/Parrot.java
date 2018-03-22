/**
 * Parrot is a Winged and also Animal
 */
public class Parrot extends Winged {
    public Parrot(String name, String favFood, double wingSpan, String skill) {
        setName(name);
        setFavoriteFood(favFood);
        setWingspan(wingSpan);
        setSkill(skill);
    }

    @Override
    public String toString() {
        return "Parrot " + super.toString();
    }
}
