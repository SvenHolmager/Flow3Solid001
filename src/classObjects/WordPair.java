/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classObjects;

/**
 *
 * @author Sven
 */
public class WordPair {
    
    private String question;
    private String answer;

    public WordPair(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "WordPair{" + "question=" + question + ", answer=" + answer + '}';
    }
    public String toString2() {
        return question + ", " + answer;
    }
    
    
    
}
