package com.example.among.function;


public class PolicyViewItem {
    String name;

    public PolicyViewItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PolicyViewItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
