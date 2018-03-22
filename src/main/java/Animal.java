import java.util.LinkedList;
import java.util.List;

/**
 * Base class for all animals.
 */
public class Animal {

    //common fields for animal types
    private String name;
    private String favoriteFood;
    private List<String> friendList = new LinkedList<String>(); //every animal has friend list

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public List<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<String> friendList) {
        this.friendList = friendList;
    }

    /**
     * This method add one friend to its friendList
     *
     * @param friendName
     */
    public void makeFriend(String friendName) {
        friendList.add(friendName);
    }

    /**
     * This method removes one friend from its friednList
     *
     * @param index
     */
    public void looseFriend(int index) {
        friendList.remove(index);
    }

    /**
     * This method checks if an animal already friends with given animal
     *
     * @param friendName
     * @return
     */
    public boolean hasFriend(String friendName) {
        if (friendList.contains(friendName)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", favFood='" + favoriteFood + '\'' +
                ", friends=" + friendList +
                '}';
    }
}
