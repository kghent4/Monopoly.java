import java.util.ArrayList;
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

            Display.inform("It's " + players.get(turn).getName() + "'s turn. Roll the dice!");

            int roll = rollDice();
            String article = roll == 1 || roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6 || roll == 7 || roll == 9 || roll == 10 || roll == 12 ? "a" : "an";

            Display.inform(players.get(turn).getName() + " rolled " + article + " " + roll + ".");

            movePlayer(roll, players.get(turn));

            turn = (turn + 1) % players.size();
        }
    }

    public static int rollDice(){
        return (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
    }

    public static void movePlayer(int roll, Player p){
        int newLoc = p.location + roll;
        if(newLoc > 40){
            Display.inform("You passed go! Collect $200!");
            p.cash += 200;
            newLoc %= 40;
        }

        p.location = newLoc;
        Display.boardPanel.repaint();
    }

    public static void landOnSquare(){
        
            //how to associate location with property object?
    }
}
