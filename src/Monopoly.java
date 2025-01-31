import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Monopoly {

    static ArrayList<Player> players = new ArrayList<Player>(1);
    static boolean gameOver = false;
    public static void main(String[] args) {

        Board b = new Board();

        players.add(new Player("Josie"));
        players.add(new Player("Adora"));
        players.add(new Player("Rose"));
        players.add(new Player("Arthur"));

        for(Player p: players){
            Display.players.add(p);
        }

        //Graphics!
        SwingUtilities.invokeLater(() -> Display.setupFrame());

        playGame();
    }

    public static void playGame(){
        gameOver = false;
        int turn = 0;
        while(!gameOver){

            Display.inform("It's " + players.get(turn).getName() + "'s turn!");
            Display.inform("Roll the dice!");

            int roll = rollDice();

            Display.inform(players.get(turn).getName() + " rolled a(n) " + roll + ".");


            turn = (turn + 1) % players.size();
        }
    }

    public static int rollDice(){
        return (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
    }
}
