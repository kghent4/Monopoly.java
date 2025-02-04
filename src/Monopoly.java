import java.util.ArrayList;
import java.util.Map;
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

        Card.fillAndShuffleChance();
        Card.fillAndShuffleCommunityChest();

        //Graphics!
        SwingUtilities.invokeLater(() -> Display.setupFrame());

        playGame();
    }

    //return true if should take a turn like normal, false otherwise
    public static boolean handleInJail(Player currentPlayer){
        int choice = 0;

        //If use get out of jail free
        if(currentPlayer.getJailFreeCards() > 0){
            choice = Display.choice("Use \"Get out of Jail Free Card?\"", currentPlayer.getName() + " is in jail. Do you want to use your card to get out of jail?", new String[]{"Yes", "No"});
            if(choice == 0){
                currentPlayer.setJailFreeCards(-1);
                currentPlayer.setInJail(false);
                currentPlayer.setNumTurnsInJail(0);
                return true;
            }
        }

        //If in jail and want to pay
        choice = Display.choice("Roll or pay?", currentPlayer.getName() + " is in jail. Do you want to pay $50 or roll the dice?", new String[]{"Roll the dice", "Pay $50"});
        if(choice == 1){
            currentPlayer.payMoney(50, null);
            currentPlayer.setInJail(false);
            currentPlayer.setNumTurnsInJail(0);
            return true;
        }

        //If try to roll for freedom
        int roll1 = rollDie();
        int roll2 = rollDie();
        int roll = roll1 + roll2;
        if(roll1 == roll2){
            
            Display.inform("You rolled a " + roll1 + " and a " + roll2 + ". Doubles!");
            currentPlayer.setInJail(false);
            currentPlayer.setNumTurnsInJail(0);
            String article = roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6 || roll == 7 || roll == 9 || roll == 10 || roll == 12 ? "a" : "an";
            Display.inform(currentPlayer.getName() + " rolled " + article + " " + roll + ".");
            currentPlayer.movePlayer(roll);
            return false;
        }

        else if(currentPlayer.getNumTurnsInJail() > 3){
            Display.inform("You must pay $50. This is your third roll.");
            currentPlayer.payMoney(50, null);
            currentPlayer.setInJail(false);
            currentPlayer.setNumTurnsInJail(0);
            currentPlayer.movePlayer(roll);
            return false;
        }

        else{
            Display.inform("You stay in jail this turn.");
            currentPlayer.setNumTurnsInJail(1);
            return false;
        }
    }

    public static void playGame(){
        gameOver = false;
        int turn = 0;
        int roll = 0;
        int doublesCount = 0;
        Player currentPlayer = players.get(turn);

        while(!gameOver){

            boolean canMove = currentPlayer.getInJail() ? handleInJail(currentPlayer) : true;

            while(canMove){

                Display.inform(currentPlayer.getName(), "It's " + currentPlayer.getName() + "'s turn. Roll the dice!");
                int roll1 = rollDie();
                int roll2 = rollDie();
                roll = roll1 + roll2;
                String extra = roll1 == roll2? " Doubles!" : "";
                String article = roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6 || roll == 7 || roll == 9 || roll == 10 || roll == 12 ? "a" : "an";
                Display.inform("Roll the dice", currentPlayer.getName() + " rolled " + article + " " + roll + "." + extra);

                if(roll1 == roll2){
                    doublesCount += 1;
                }
                else{
                    canMove = false;
                    doublesCount = 0;
                }

                if(doublesCount == 3){
                    Display.inform(":(", "3 Doubles in a row. You go to jail.");
                    currentPlayer.setInJail(true);
                    currentPlayer.setNumTurnsInJail(1);
                    canMove = false;
                }
                else{
                    players.get(turn).movePlayer(roll);
                }
                
            }

            turn = (turn + 1) % players.size();
        }
    }

    public static int rollDie(){
        return (int)(Math.random() * 6 + 1);
    }
}
