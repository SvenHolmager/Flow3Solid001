/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classObjects;

import java.util.ArrayList;

/**
 *
 * @author Sven
 */
public class Quizz {

    private String name;
    private ArrayList<WordPair> arrayListWordPairs;
    private WordPair currentWordPair;
    
    public Quizz(String name, ArrayList<WordPair> wordPairs) {
        this.name = name;
        this.arrayListWordPairs = wordPairs;
        this.currentWordPair = null;

        if (wordPairs != null) {
            this.arrayListWordPairs = wordPairs;
        } else {
            this.arrayListWordPairs = new ArrayList<>();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WordPair> getArrayListWordPairs() {
        return arrayListWordPairs;
    }

    public void setArrayListWordPairs(ArrayList<WordPair> arrayListWordPairs) {
        this.arrayListWordPairs = arrayListWordPairs;
    }

    public WordPair getCurrentWordPair() {
        return currentWordPair;
    }

    public void setCurrentWordPair(WordPair currentWordPair) {
        this.currentWordPair = currentWordPair;
    }
    
}