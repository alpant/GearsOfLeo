/**
 * Winged animals extends from Animal
 */
public class Winged extends Animal {

    //They have some extra fields
    private double wingspan;
    private String skill;

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "{" +
                "wingspan=" + wingspan +
                ", skill='" + skill + '\'' +
                "} " + super.toString();
    }
}
