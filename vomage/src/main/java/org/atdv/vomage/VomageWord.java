package org.atdv.vomage;

/**
 * Created by matsumotius on 15/05/05.
 */
public class VomageWord {

    private final EnglishWord englishWord;

    private final JapaneseMeaning japaneseMeaning;

    private final ImageMeaning imageMeaning;

    public VomageWord(EnglishWord englishWord, JapaneseMeaning japaneseMeaning, ImageMeaning imageMeaning) {
        this.englishWord = englishWord;
        this.japaneseMeaning = japaneseMeaning;
        this.imageMeaning = imageMeaning;
    }

    public EnglishWord getEnglishWord() {
        return englishWord;
    }

    public JapaneseMeaning getJapaneseMeaning() {
        return japaneseMeaning;
    }

    public ImageMeaning getImageMeaning() {
        return imageMeaning;
    }

}
