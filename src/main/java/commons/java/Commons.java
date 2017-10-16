package commons.java;

import commons.java.Config;
import commons.java.User;

/**
 * Replacement for a Scala package object.
 *
 * Static variables here, in reality, will be most probably instance memebrs or local variables, hence
 * breaking the Java naming convention to get same
 * variable names in the code comparison.
 */
public interface Commons {

    public static final User currentUser = new User("Jane", "Doe");
    public static final Config config = new Config(true);

    public static void notifyUser(User user, String message) {
        System.out.println("Notified " + user.getFullName() + " with " + message);
    }

}
