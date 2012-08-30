package com.example.packagechanges;

// this is a json mapped pojo

import java.util.List;

public class ApplicationNotification extends BaseApplicationNotification 
   implements java.io.Serializable {

   public List<PackageNotification> packages;

   /**
    * IF YOU CHANGE THIS CLASS CHANGE THIS NUMBER
    */
   private static final long serialVersionUID = 2L;
   
   public ApplicationNotification() {
      type = "applications";
   }
   
   public int hashCode() {
      return type.hashCode() * packages.hashCode();
   }
   
}
