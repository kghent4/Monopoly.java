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
        communityChest.add(new Card("Advance to Go. Collect $200.", "move", 0, 0));
        communityChest.add(new Card("Bank error in your favor. Collect $200.", "money", 200, 0));
        communityChest.add(new Card("Doctor’s fee. Pay $50", "money", -50, 0));
        communityChest.add(new Card("From sale of stock you get $50", "money", 50, 0));
        communityChest.add(new Card("Get Out of Jail Free.", "outOfJail", 0, 0));
        communityChest.add(new Card("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200.", "jail", 0, 0));
        communityChest.add(new Card("Holiday fund matures. Receive $100", "money", 100, 0));
        communityChest.add(new Card("Income tax refund. Collect $20.", "money", 20, 0));
        communityChest.add(new Card("It is your birthday. Collect $10 from every player.", "allMoney", 10, 0));
        communityChest.add(new Card("Life insurance matures. Collect $100", "money", 100, 0));
        communityChest.add(new Card("Pay hospital fees of $100", "money", -100, 0));
        communityChest.add(new Card("Pay school fees of $50", "money", -50, 0));
        communityChest.add(new Card("Receive $25 consultancy fee", "money", 25, 0));
        communityChest.add(new Card("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.", "repairs", 0, 0));
        communityChest.add(new Card("You have won second prize in a beauty contest. Collect $10", "money", 10, 0));
        communityChest.add(new Card("You inherit $100", "money", 100, 0));

        Collections.shuffle(chance);
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
        chance.add(new Card("Go Back 3 Spaces.", "moveBack", 0, 0)); 
        chance.add(new Card("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200.", "jail", 0, 0));
        chance.add(new Card("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.", "repairs", 0, 0));
        chance.add(new Card("Speeding fine $15.", "money", -15, 0));
        chance.add(new Card("Take a trip to Reading Railroad. If you pass Go, collect $200.", "move", 0, 5));
        chance.add(new Card("You have been elected Chairman of the Board. Pay each player $50.", "allMoney", -50, 0));
        chance.add(new Card("Your building loan matures. Collect $150", "money", 150, 0));

        Collections.shuffle(chance);
    }

    public void takeCardAction(Player p){
        switch(type) {
            case "move":
                if(specificSpace > p.location){
                    p.movePlayer(specificSpace - p.location);
                }
                else if(specificSpace == p.location){
                    p.movePlayer(40);
                }
                else{
                    p.movePlayer(40-(p.location - specificSpace));
                }
                break;
            case "money":
                if(money > 0){
                    p.changeCash(money);
                }
                else{
                    p.payMoney(money, null);
                }
                break;
            case "jail":
                p.setLocation(10);;
                p.setCurrentProperty(Board.propertiesMap.get(10));
                p.goToJail();
                break;
            case "allMoney":
                if(money < 0){
                    for(Player other: Monopoly.players){
                        p.payMoney(money, other);
                    }
                }
                else{
                    for(Player other: Monopoly.players){
                        other.payMoney(money, p);
                    }
                }
                break;

            case "repairs":
                int houseCount = 0;
                for(Property prop: p.getProperties()){
                    houseCount += prop.numHouses;
                }
                p.payMoney(houseCount * 25, null);
                break;
            case "outOfJail":
                p.setInJail(false);
                p.setNumTurnsInJail(0);
                break;
            case "moveBack":
                if(p.getLocation() - 3 >= 0){
                    p.movePlayer(-3);
                }
                else{
                    p.movePlayer(39 - p.getLocation());
                }
                break;
            case "railroad":
                int numAway = p.getLocation() < 6 ? (5 - p.getLocation()) : p.getLocation() < 15 ? (15-p.getLocation()) : p.getLocation() < 25 ? (25 - p.getLocation()) : p.getLocation() < 35 ? (35 - p.getLocation()) : (39-p.getLocation()) + 6;
                p.movePlayer(numAway);
                break;
            case "utility":
                int numAway2 = p.getLocation() < 12 ? (12 - p.getLocation()) : p.getLocation() < 28 ? (28 - p.getLocation()) : (40-p.getLocation()) + 12;
                p.movePlayer(numAway2);
                break;
            default:
                System.out.println("Something went wrong in Card.takeCardAction");
        }
    }

    public static Card drawCommunityCard(){
        return null;
    }

    public static Card drawChanceCard(){
        return null;
    }
}
