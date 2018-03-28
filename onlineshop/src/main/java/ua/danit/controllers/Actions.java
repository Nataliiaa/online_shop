package ua.danit.controllers;

public enum Actions {
    ADD("/add"), REMOVE("/remove"), REMOVEALL("/removeall");

    private String action;

    Actions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}