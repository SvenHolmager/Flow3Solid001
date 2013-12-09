/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3solid001;

import controllers.GameController;

/**
 *
 * @author Sven
 */
public class Flow3Solid001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.addGame("Capitals");
        gameController.add("Denmark", "Copenhagen");
        gameController.add("England", "London");
        gameController.add("Sweden", "Stockholm");
        gameController.add("Norway", "Oslo");

        gameController.save(gameController.getCurrentQuizz().getName());

        System.out.println(gameController.getSelectedGameName());
        System.out.println(gameController.getCurrentQuizz().getArrayListWordPairs().size());

        System.out.println(gameController.getRandomQuestion());

        gameController.addGame("Planets");
        gameController.add("1th from the sun", "Mercury");
        gameController.add("2nd from the sun", "Venus");
        gameController.add("3rd from the sun", "Earth");
        gameController.add("4th from the sun", "Mars");
        gameController.save(gameController.getCurrentQuizz().getName());

        System.out.println(gameController.getSelectedGameName());
        System.out.println(gameController.getCurrentQuizz().getArrayListWordPairs().size());

        System.out.println(gameController.getRandomQuestion());

        
        gameController.load("Capitals");
        System.out.println(gameController.getCurrentQuizz().getArrayListWordPairs().toString());
        
    }
}
