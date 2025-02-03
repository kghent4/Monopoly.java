
import java.util.ArrayList;

public class Player {

    ArrayList<Property> propertiesOwned = new ArrayList<>();
    String name;
    int cash;
    int location;
    Property currentProperty;

    public Player(String name){
        this.name = name;
        cash = 2000;
        location = 0;
        currentProperty = Board.propertiesMap.get(0);
    }

    public void landOnProperty(){
        System.out.println("in land on property");
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

    public void buy(){
        String[] options = {"Yes", "No"};
        int choice = Display.choice("Available Property", "Do you want to buy " + currentProperty.getName() + " for $" + currentProperty.cost + "?", options);
        if(choice == 0){
            if(cash >= currentProperty.cost){
                propertiesOwned.add(currentProperty);
                currentProperty.owner = this;
                cash -= currentProperty.cost;
                Display.inform("You bought " + currentProperty.getName() + "!");
                Display.boardPanel.repaint();
            }
            else{
                Display.inform("You don't have enough cash!");
            }
        }
    }

    public void payRent(){
        Player landlord = currentProperty.owner;
        Display.inform("You owe " + landlord.getName() + " $" + currentProperty.rent + " in rent!");
        if(cash - currentProperty.getRent() >= 0){
            cash -= currentProperty.getRent();
            landlord.cash += currentProperty.getRent();
        }

        else{
            Display.inform("You are bankrupt!");
            bankrupt(landlord);
        }
    }

    public void specialAction(){
//todo
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

    public ArrayList<Property> getProperties(){
        
        return propertiesOwned;
    }

    public int getLocation(){
        return location;
    }
}
