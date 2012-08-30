package com.example.packagechanges;

// this is a json mapped pojo
public class ActivityNotification implements java.io.Serializable {
    public String activityName;
    public String activityClass;

    private static final long serialVersionUID = 2L;

    public int hashCode() {
        int ret = 31415;
        if (activityName != null) ret = ret ^ (activityName.hashCode() * 97);
        if (activityClass != null) ret = ret ^ (activityClass.hashCode() * 17);
        return ret;
    }
}