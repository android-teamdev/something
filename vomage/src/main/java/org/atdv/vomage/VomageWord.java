package org.atdv.vomage;

/**
 * Created by matsumotius on 15/05/05.
 */
public class VomageWord {

    private final EnglishWord englishWord;

    private final JapaneseMeaning japaneseMeaning;

    public VomageWord(EnglishWord englishWord, JapaneseMeaning japaneseMeaning) {
        this.englishWord = englishWord;
        this.japaneseMeaning = japaneseMeaning;
    }

    public EnglishWord getEnglishWord() {
        return englishWord;
    }

    public JapaneseMeaning getJapaneseMeaning() {
        return japaneseMeaning;
    }

}
