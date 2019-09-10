package com.example.android.catstagram;

public class Facts {
    private String text;


    public Facts(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "The fact is " + text;
    }

    public String getText() {
        return text;
    }
}
