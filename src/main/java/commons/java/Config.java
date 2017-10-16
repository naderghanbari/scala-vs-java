package commons.java;

public class Config {

    private Boolean notificationEnabled;

    public Config(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public Boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

}
