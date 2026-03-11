package com.mycompany.filemonitoring.helper;

public class OfficeOption {
    private String label; // what user sees
    private String value; // what you store in DB

    public OfficeOption(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}
