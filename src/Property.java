
import java.awt.Color;

public class Property {


    Color color;
    String name;
    Player owner;
    int rent;
    int houseCost;
    String type;
    int setSize;
    int numHouses;
    int cost;

    public Property(Color c, String n, int r, int hc, String t, int s, int cost){
        color = c;
        this.cost = cost;
        name = n;
        rent = r;
        houseCost = hc;
        type = t;
        numHouses = 0;
        owner = null;
        setSize = s;
        houseCost = hc;
    }

    public Color getColor(){
        return color;
    }

    public String getName(){
        return name;
    }

    public int getNumHouses(){
        return numHouses;
    }

    public Player getOwner(){
        return owner;
    }

    public int getRent(){

        int setCount = 0;
        int multiplier = 1;

        switch(type){
            case "property":

                if(numHouses != 0){
                    multiplier *= numHouses;
                }

                if(owner != null){
                    for(Property p: this.owner.getProperties()){
                        if(p.color.equals(this.color)){
                            setCount++;
                        }
                    }
                    if(setCount == setSize){
                        multiplier += 1;
                    }
                }

                return rent * multiplier;

            case "railroad":
                if(owner != null){

                    for(Property p: this.owner.propertiesOwned){
                        if(p.color.equals(this.color)){
                            setCount++;
                        }
                    }
                    
                    multiplier = setCount;
                }

                return rent * multiplier;
                    
            case "utility":
                if(owner != null){

                    for(Property p: this.owner.propertiesOwned){
                        if(p.name.equals("Water Works") || p.name.equals("Electric Company") ){
                            setCount++;
                        }
                    }
                    
                    multiplier = setCount;
                }

                return rent * multiplier;
            default:
                System.out.println("Something went wrong. Invalid property type when trying to calculate rent.");
                
        }
        return rent;
    }
}
