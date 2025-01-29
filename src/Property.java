
import java.awt.Color;

public class Property {

    Color color;
    String name;
    String owner;
    int rent;
    int houseCost;
    String type;

    int numHouses;

    public Property(Color c, String n, int r, int hc, String t){
        color = c;
        name = n;
        rent = r;
        houseCost = hc;
        type = t;
        numHouses = 0;
        owner = "none";
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

    public String getOwner(){
        return owner;
    }

    public int getRent(){
        return rent;
    }
}
