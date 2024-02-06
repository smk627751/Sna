package com.smk627751.dto;

public class Player {
    private final String name;
    private int position;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
