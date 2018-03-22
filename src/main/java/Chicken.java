/**
 * Chicken is Winged and also Animal
 */
public class Chicken extends Winged {
    public Chicken(String name, String favFood, double wingSpan, String skill) {
        setName(name);
        setFavoriteFood(favFood);
        setWingspan(wingSpan);
        setSkill(skill);
    }

    @Override
    public String toString() {
        return "Chicken " + super.toString();
    }
}
