/**
 * Dog class extends from Animal
 */
public class Dog extends Animal {

    //A dog has animal fields and also has a type
    private DogType type;

    public Dog(String name, String favFood, DogType type) {
        setName(name);
        setFavoriteFood(favFood);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{" + type +
                "} " + super.toString();
    }
}
