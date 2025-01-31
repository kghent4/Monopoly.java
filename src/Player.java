
import java.util.ArrayList;

public class Player {

    ArrayList<Property> propertiesOwned = new ArrayList<>();
    String name;
    int cash;
    int location;

    public Player(String name){
        this.name = name;
        cash = 2000;
        location = 0;
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
