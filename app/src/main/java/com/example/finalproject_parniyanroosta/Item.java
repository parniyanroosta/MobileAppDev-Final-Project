package com.example.finalproject_parniyanroosta;

 // Data model for each row of the RecyclerView

public class Item {

    // Member variables representing the title and information about the items to be displayed.
    private String title;
    private String description;
    private final int imageResource;
    private int price;


    // Constructor for the Item data model.
    public Item(String title, String description, int imageResource, int price) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.price = price;
    }

    String getTitle() { return title; }
    String getInfo() { return description; }
    public int getPrice() { return price;  }
    public int getImageResource() { return imageResource; }

}