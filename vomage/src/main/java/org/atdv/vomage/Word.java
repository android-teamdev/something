package org.atdv.vomage;

/**
 * Created by matsumotius on 15/05/05.
 */
public abstract class Word {

    private final String text;

    public Word(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
