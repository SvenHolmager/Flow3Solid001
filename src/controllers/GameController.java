/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classObjects.Quizz;
import classObjects.WordPair;
import interfaces.QuizzControlInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sven
 */
public class GameController implements QuizzControlInterface {

    private ArrayList<Quizz> arrayListQuizz;
    private Quizz currentQuizz;

    public GameController() {
        this.arrayListQuizz = new ArrayList<>();
    }

    //Adds a word to the quizz
    @Override
    public void add(String question, String answer) {
        WordPair wordPair = new WordPair(question, answer);
        currentQuizz.getArrayListWordPairs().add(wordPair);
    }

    @Override
    public int size() {
        if (arrayListQuizz != null) {
            return currentQuizz.getArrayListWordPairs().size();
        } else {
            return 0;
        }
    }

    @Override
    public String getRandomQuestion() {

        if (size() > 0) {
            int random = (int) (Math.random() * size());
            return currentQuizz.getArrayListWordPairs().get(random).getQuestion();
        } else {
            return "No wordpairs were found...";
        }
    }

    @Override
    public boolean checkGuess(String question, String guess) {

        WordPair wordPair = getWordPairFromQuestion(question);

        if (wordPair != null) {
            return wordPair.getAnswer().equals(guess);
        } else {
            return false;
        }
    }

    @Override
    public String lookup(String question) {

        WordPair wordPair = getWordPairFromQuestion(question);

        if (wordPair != null) {
            return wordPair.getAnswer();
        } else {
            return "Word not found!";
        }
    }

    @Override
    public boolean load(String filename) {

        boolean succes = false;
        clear();
        Scanner input1 = null;
        WordPair wordPair;

        // Set .txt path case filename doesn't contains it
        int i = filename.lastIndexOf('.');
        if (i == -1 || !("txt".equals(filename.substring(i + 1)))) {
            filename = filename + ".txt";
        }

        try {
            input1 = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scan = new Scanner(input1.nextLine());
        scan.useDelimiter(", ");
        String name = scan.next();
        currentQuizz.setName(name);
        System.out.println(name);
        while (input1.hasNextLine()) {
            String question = scan.next();
            String answer = scan.next();
            System.out.println(question + " " + answer);
            wordPair = new WordPair(question, answer);
            currentQuizz.getArrayListWordPairs().add(wordPair);
        }
        succes = true;
        input1.close();
        return succes;
    }

    @Override
    public boolean save(String filename) {

        boolean succes = false;
        FileWriter writer = null;
        PrintWriter printWriter = null;

        
        try {

            writer = new FileWriter(new File(filename+ ".txt"));
            printWriter = new PrintWriter(writer);
            printWriter.println(filename);

            for (int j = 0; j < currentQuizz.getArrayListWordPairs().size(); j++) {
                printWriter.println(currentQuizz.getArrayListWordPairs().get(j).toString2());
//                System.out.print(currentQuizz.getArrayListWordPairs().get(j).toString() + "\n");
            }
            succes = true;
            writer.close();
            printWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succes;
    }

    @Override
    public void clear() {
        currentQuizz.getArrayListWordPairs().clear();
    }

    private WordPair getWordPairFromQuestion(String question) {
        for (WordPair wordPair : currentQuizz.getArrayListWordPairs()) {
            if (wordPair.getQuestion().equals(question)) {
                return wordPair;
            }
        }
        return null;
    }

    public ArrayList<Quizz> getArrayListQuizz() {
        return arrayListQuizz;
    }

    public void setArrayListQuizz(ArrayList<Quizz> arrayListQuizz) {
        this.arrayListQuizz = arrayListQuizz;
    }

    public Quizz getCurrentQuizz() {
        return currentQuizz;
    }

    public void setCurrentQuizz(Quizz currentQuizz) {
        this.currentQuizz = currentQuizz;
    }

    @Override
    public String[] getGameNames() {
        return null;
    }

    @Override
    public void selectGame(String gameName) {
    }

    @Override
    public String getSelectedGameName() {
        return currentQuizz.getName();
    }

    @Override
    public void addGame(String gameName) {
        Quizz quizz = new Quizz(gameName, null);
        currentQuizz = quizz;
        arrayListQuizz.add(quizz);
    }
}
