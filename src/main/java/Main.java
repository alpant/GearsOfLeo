import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is the main class for logic and Console screen
 * Responsible for zoo creation, printing animals, establishing and loosing friendships
 */
public class Main {

    //all animals stay in this list
    public static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static void main(String[] args) {
        ArrayList<Animal> animals = createZoo();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int selection;
        boolean done = false;
        try {
            while (done == false) {
                do {
                    System.out.println();
                    System.out.println("1. List all animals");
                    System.out.println("2. Live one day");
                    System.out.println("3. Exit");
                    String input = console.readLine();
                    selection = Integer.parseInt(input);

                    switch (selection) {
                        case 1:
                            printZoo(animals);
                            break;
                        case 2:
                            liveOneDay(animals);
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println("Invalid option.  Please try again: ");
                            break;
                    }

                } while (selection > 3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates all animals with given properties
     *
     * @return
     */
    public static ArrayList<Animal> createZoo() {
        Dog dog1 = new Dog("dog one", "meat", DogType.HUNTING);
        Dog dog2 = new Dog("dog two", "fresh meat", DogType.ASSISTANCE);
        Dog dog3 = new Dog("dog three", "pedigree", DogType.RACING);

        Parrot parrot1 = new Parrot("parrot one", "grain", 0.25, "cannot speak");
        Parrot parrot2 = new Parrot("parrot two", "corn", 0.5, "can speak");

        Chicken chicken1 = new Chicken("chicken one", "corn", 0.75, "is broiler");
        Chicken chicken2 = new Chicken("chicken two", "corn", 0.75, "is not broiler");

        animals.add(dog1);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(parrot1);
        animals.add(parrot2);
        animals.add(chicken1);
        animals.add(chicken2);
        return animals;
    }

    /**
     * prints all animals' features to the console
     *
     * @param animals
     */
    public static void printZoo(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    /**
     * responsible for main logic
     *
     * @param animals
     */
    public static void liveOneDay(ArrayList<Animal> animals) {
        looseSomeFriends(animals);
        System.out.println();
        makeSomeFriends(animals);
    }

    /**
     * generates random values to make friendships
     *
     * @param animals
     */
    public static ArrayList<Animal> makeSomeFriends(ArrayList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            int index = getRandom(0, 6, i); //generate random index
            if (!animals.get(i).hasFriend(animals.get(index).getName()))
                animals.get(i).makeFriend(animals.get(index).getName()); //make friend i with random index
            if (!animals.get(index).hasFriend(animals.get(i).getName()))
                animals.get(index).makeFriend(animals.get(i).getName()); //make friend index with random i

            System.out.printf("%s has established friendship with %s \n", animals.get(i).getName(), animals.get(index).getName());
            System.out.printf("%s has established friendship with %s \n", animals.get(index).getName(), animals.get(i).getName());
        }

        return animals;
    }

    /**
     * generates random values to loose friendships
     *
     * @param animals
     */
    public static ArrayList<Animal> looseSomeFriends(ArrayList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {

            if (animals.get(i).getFriendList().size() == 0)
                return null;

            int index = getRandom(0, animals.get(i).getFriendList().size() - 1);
            String friendName = animals.get(i).getFriendList().get(index);
            animals.get(i).looseFriend(index);

            int realIndex = 0;
            for (int j = 0; j < animals.size(); j++) {
                if (animals.get(j).getName().equals(friendName)) {
                    realIndex = j;
                    break;
                }
            }

            int ind2 = animals.get(realIndex).getFriendList().indexOf(animals.get(i).getName());
            animals.get(realIndex).getFriendList().remove(ind2);

            System.out.printf("%s has lost friendship with %s \n", animals.get(i).getName(), friendName);
            System.out.printf("%s has lost friendship with %s \n", friendName, animals.get(i).getName());
        }
        return animals;
    }

    /**
     * random number generator with exclude values
     *
     * @param start
     * @param end
     * @param exclude
     * @return
     */
    public static int getRandom(int start, int end, int... exclude) {
        int random = start + new Random().nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

}
