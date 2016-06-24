package com.bredikhin;

/**
 * Created by Pavel on 22.06.2016.
 */
public class ParseWord {
    private String word;
    private long hash;
    private String[] nGram;
    private ParseWord[] variations;


    public ParseWord(String word) {
        this.word = word;
        this.nGram = Utilities.get2Gramm(word);
        this.hash = Utilities.hashLy(word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public String[] getnGram() {
        return nGram;
    }

    public void setnGram(String[] nGram) {
        this.nGram = nGram;
    }

    public ParseWord[] getVariations() {
        return variations;
    }

    public void setVariations(ParseWord[] variations) {
        this.variations = variations;
    }
}
