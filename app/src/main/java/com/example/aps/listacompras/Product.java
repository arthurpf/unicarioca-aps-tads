package com.example.aps.listacompras;

public class Product {
    private String name;
    private int quantity;
    private float value;

    public Product(String name, int quantity, float value) {
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
