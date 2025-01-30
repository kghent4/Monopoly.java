
import java.awt.Color;
import java.util.ArrayList;

public class Player {

    //TODO FIX
    public String getName(){
        return "no one";
    }

    ///TODO FIX
    public int getMoney(){
        return 1000;
    }

    //TODO FIX
    public ArrayList<Property> getProperties(){
        ArrayList<Property> p = new ArrayList<>();
        p.add(new Property(Color.BLACK, "oslo", 0, 0, "sdfd"));
        p.add(new Property(Color.BLACK, "oslo", 0, 0, "sdfd"));
        p.add(new Property(Color.BLACK, "oslo", 0, 0, "sdfd"));
        p.add(new Property(Color.BLACK, "oslo", 0, 0, "sdfd"));
        
        return p;
    }

    //TODO FIX
    //Go is the top left corner, location 0. Locations increase by 1 for each property that the player passes clockwise.
    public int getLocation(){
        return 21;
    }
}
