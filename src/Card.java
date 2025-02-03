import java.util.ArrayList;
import java.util.Collections;

public class Card {
    static ArrayList<Card> communityChest = new ArrayList<>();
    static ArrayList<Card> chance = new ArrayList<>();

    String text;
    int money;
    int specificSpace;
    String type;

    public Card(String te, String ty, int m, int sSpc){
        text = te;
        type = ty;
        specificSpace = sSpc;
    }

    public static void fillAndShuffleCommunityChest(){
        
    }

    public static void fillAndShuffleChance(){
        chance.add(new Card("Advance to Boardwalk", "move", 0, 39));
        chance.add(new Card("Advance to Go. Collect $200.", "move", 0, 0));
        chance.add(new Card("Advance to Illinois Avenue. If you pass Go, collect $200.", "move", 0, 24));
        chance.add(new Card("Advance to St. Charles Place. If you pass Go, collect $200.", "move", 0, 11));
        chance.add(new Card("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled.", "railroad", 0, 0));
        chance.add(new Card("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled.", "railroad", 0, 0));
        chance.add(new Card("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.", "utility", 0, 0));
        chance.add(new Card("Bank pays you dividend of $50.", "money", 50, 0));
        chance.add(new Card("Get Out of Jail Free.", "outOfJail", 0, 0));
        chance.add(new Card("Go Back 3 Spaces.", "outOfJail", 0, 0)); 
        chance.add(new Card("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200.", "jail", 0, 0));
        chance.add(new Card("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.", "repairs", 0, 0));
        chance.add(new Card("Speeding fine $15.", "money", -15, 0));
        chance.add(new Card("Take a trip to Reading Railroad. If you pass Go, collect $200.", "move", 0, 5));
        chance.add(new Card("You have been elected Chairman of the Board. Pay each player $50.", "allMoney", -50, 0));

        Collections.shuffle(chance);
    }


}
