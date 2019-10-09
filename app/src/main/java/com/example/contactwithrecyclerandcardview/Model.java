package com.example.contactwithrecyclerandcardview;

import java.util.Comparator;

public class Model {

    String title,number;
    public int image;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public  static final Comparator<Model> BY_TITLE_ASCENDING =new Comparator<Model>() {
        @Override
        public int compare(Model model, Model t1) {
            return model.getTitle().compareTo(t1.getTitle());
        }
    };
   public static final Comparator<Model> BY_TITLE_DESCENDING = new Comparator<Model>() {
       @Override
       public int compare(Model model, Model t1) {
           return t1.getTitle().compareTo(model.getTitle());
       }
   };
}
