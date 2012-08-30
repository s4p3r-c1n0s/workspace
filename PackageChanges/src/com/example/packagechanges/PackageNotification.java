package com.example.packagechanges;

// this is a json mapped pojo

import java.util.List;

public class PackageNotification implements java.io.Serializable {
    public String packageName;
    public List<ActivityNotification> activities;

    /**
     * IF YOU CHANGE THIS CLASS CHANGE THIS NUMBER
     */
    private static final long serialVersionUID = 2L;
    
    public int hashCode() {
        int ret = 28903;
        if (packageName != null) ret = ret ^ (packageName.hashCode() * 3);
        ret = ret ^ (activities.hashCode() * 7);
        return ret;
    }
}