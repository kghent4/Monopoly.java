
import java.util.ArrayList;

public class Player {

    private ArrayList<Property> propertiesOwned = new ArrayList<>();
    private final String name;
    private int cash;
    private int location;
    private Property currentProperty;
    private boolean inJail = false;
    private int numTurnsInJail = 0;
    private int jailFreeCards;

    public Player(String name){
        this.name = name;
        cash = 2000;
        location = 0;
        currentProperty = Board.propertiesMap.get(0);
        jailFreeCards = 0;
    }

    public void movePlayer(int roll){
        int newLoc = location + roll;

        if(newLoc >= 40){
            Display.inform(name, "You passed go! Collect $200!");
            cash += 200;
            newLoc %= 40;
        }

        location = newLoc;
        Display.boardPanel.repaint();

        currentProperty = Board.propertiesMap.get(location);
       // landOnProperty(); TODO demo only out
    }

    public int getJailFreeCards(){
        return jailFreeCards;
    }

    public void setJailFreeCards(int n){
        jailFreeCards += n;
    }

    public void landOnProperty(){
        switch(currentProperty.type){
            case "utility":
            case "railroad":
            case "property":
                if(currentProperty.owner == null){
                    buy();
                }
                else{
                    payRent();
                }
                break;
            default:
                specialAction();
        }

        //TODO if a current set is completed
        buyAndSellHouses();
    }

    public void setInJail(boolean b){
        inJail = b;
    }

    public boolean getInJail(){
        return inJail;
    }

    public int getNumTurnsInJail(){
        return numTurnsInJail;
    }

    public void setNumTurnsInJail(int num){
        numTurnsInJail = num;
    }

    public void buy(){
        String[] options = {"Yes", "No"};
        int choice = Display.choice(name, "Do you want to buy " + currentProperty.getName() + " for $" + currentProperty.cost + "?", options);
        if(choice == 0){
            if(cash >= currentProperty.cost){
                propertiesOwned.add(currentProperty);
                currentProperty.owner = this;
                cash -= currentProperty.cost;
                Display.inform(name, "You bought " + currentProperty.getName() + "!");
                Display.boardPanel.repaint();
            }
            else{
                Display.inform(name, "You don't have enough cash!");
            }
        }
    }

    public void payRent(){
        Player landlord = currentProperty.owner;
        Display.inform("You owe " + landlord.getName() + " $" + currentProperty.rent + " in rent!");
        payMoney(currentProperty.rent, currentProperty.owner);
    }

    public void specialAction(){
        switch(currentProperty.name){
            case "Income Tax":
                Display.inform(name, "You must pay the bank $200.");
                payMoney(200, null);
                break;
            case "Luxury Tax":
                Display.inform(name, "You must pay the bank $75.");
                payMoney(75, null);
                break;
            case "Go":
            case "Free Parking":
            case "Jail":
                break;
            case "Community Chest":
                Card drawnCard = Card.drawCommunityCard();
                drawnCard.takeCardAction(this);
                if(drawnCard.type.equals("outOfJail")){
                    jailFreeCards++;
                }
                break;
            case "Chance":
                Card drawnCard2 = Card.drawChanceCard();
                drawnCard2.takeCardAction(this);
                if(drawnCard2.type.equals("outOfJail")){
                    jailFreeCards++;
                }
                break;
            case "Go to Jail":
                //todo
            default:
                System.out.println("Something went wrong. Invalid property type.");
                break;
        }
    }

    public void goToJail(){
        inJail = true;
        numTurnsInJail = 1;
    }

    public void bankrupt(Player owed){
        //todo
    }

    public void buyAndSellHouses(){
//todo
    }

    public String getName(){
        return name;
    }

    public int getMoney(){
        return cash;
    }

    public void payMoney(int amount, Player owedTo){
        if(cash < amount){
            Display.inform(name, "You are bankrupt!");
            bankrupt(owedTo);
            return;
        }
        if(owedTo != null){
            owedTo.cash += amount;
        }
        cash -= amount;
        Display.boardPanel.repaint();
    }

    public ArrayList<Property> getProperties(){
        
        return propertiesOwned;
    }

    public Property getCurrentProperty(){
        return currentProperty;
    }

    public int getLocation(){
        return location;
    }

    public void setCurrentProperty(Property p){
        currentProperty = p;
    }

    public void setLocation(int loc){
        location = loc;
    }

    public void changeCash(int c){
        cash += c;
    }
}
