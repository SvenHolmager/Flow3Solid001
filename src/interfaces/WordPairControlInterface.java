/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Sven
 */
public interface WordPairControlInterface {

    /**
     * Pre: Post: A new word pair is added to the existing collection of word
     * pairs
     */
    void add(String question, String answer);

    /**
     * Pre: Post: Returns the number of wordpairs
     */
    int size();

    /**
     * Pre: At least one word pair must be present Post: Returns a question
     * randomly selected from the collection of word pairs
     */
    String getRandomQuestion();

    /**
     * Pre: Post: Returns true if (question, quess) exists as a word pair in the
     * collection, otherwise false
     */
    boolean checkGuess(String question, String guess);

    /**
     * Pre: Post: Returns the answer corresponding to the question if this
     * exists in the collection. Otherwise it returns null.
     */
    String lookup(String question);

    /**
     * Pre: Post: Word pairs are read from the file Ã¢â‚¬Å“filenameÃ¢â‚¬ï¿½ and
     * added to the collection of word pairs. Returns true if successfully done.
     * Otherwise it returns false.
     */
    boolean load(String filename);

    /**
     * Pre: Post: All word pairs from the collection has been written to the
     * file Ã¢â‚¬Å“filenameÃ¢â‚¬ï¿½ Returns true if successfully done. Otherwise
     * false.
     */
    boolean save(String filename);

    /**
     * Pre: Post: The existing collection of word pairs is cleared
     */
    void clear();
}

