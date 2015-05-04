package org.atdv.vomage;

/**
 * Created by matsumotius on 15/05/05.
 */
public class VomageWord {

    private final EnglishWord englishWord;

    private final JapaneseWord japaneseWord;

    public VomageWord(EnglishWord englishWord, JapaneseWord japaneseWord) {
        this.englishWord = englishWord;
        this.japaneseWord = japaneseWord;
    }

    public EnglishWord getEnglishWord() {
        return englishWord;
    }

    public JapaneseWord getJapaneseWord() {
        return japaneseWord;
    }

}
