package com.example.recyclerview;

public class Item {
    String name;
    String CEO;
    String stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Item(String name, String CEO, String stock) {
        this.name = name;
        this.CEO = CEO;
        this.stock = stock;
    }
}
