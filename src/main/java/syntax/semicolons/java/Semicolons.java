package syntax.semicolons.java;

import static commons.java.Commons.*;

public class Semicolons {

    public static void main(String[] args) {
        String message = "Error occurred!";
        Boolean shouldNotifyUser = config.isNotificationEnabled();
        if (shouldNotifyUser) {
            notifyUser(currentUser, message);
        }
    }

}
