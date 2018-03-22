import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {

    public static ArrayList<Animal> animals;
    public static Main m;

    @Test
    public void test_CreateZoo() {
        animals = new ArrayList<Animal>();
        animals = m.createZoo();
        Assert.assertEquals(animals.size(), 7);
    }

    @Test
    public void test_MakeSomeFriend() {
        animals = new ArrayList<Animal>();
        animals = m.createZoo();
        Assert.assertNotNull(m.makeSomeFriends(animals));
    }

    @Test
    public void test_LooseSomeFriend() {
        animals = new ArrayList<Animal>();
        animals = m.createZoo();
        Assert.assertNull(m.looseSomeFriends(animals));
    }
}


