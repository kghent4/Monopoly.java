
import java.awt.Color;

public class Board {
    
    Property[][] properties = new Property[11][11];

    public Board(){

        Display.properties = properties;
        properties[0][0] = new Property(new Color(240, 230, 200), "Go", 0, 0, "neutral", 0, 0);
        properties[1][0] = new Property(new Color(102,51,0), "Mediterranean Avenue", 2, 50, "property", 2, 60);
        properties[2][0] = new Property(new Color(240, 230, 200), "Community Chest", 0, 0, "neutral", 0, 0);
        properties[3][0] = new Property(new Color(102,51,0), "Baltic Avenue", 4, 50, "property", 2, 60);
        properties[4][0] = new Property(new Color(240, 230, 200), "Income Tax", 0, 0, "neutral", 0, 0);
        properties[5][0] = new Property(Color.black, "Reading Railroad", 25, 0, "railroad", 4, 200);
        properties[6][0] = new Property(new Color(0,153,204), "Oriental Avenue", 6, 50, "property", 3, 100);
        properties[7][0] = new Property(new Color(240, 230, 200), "Chance", 0, 0, "neutral", 0, 0);
        properties[8][0] = new Property(new Color(0,153,204), "Vermont Avenue", 6, 50, "property", 3, 100);
        properties[9][0] = new Property(new Color(0,153,204), "Connecticut Avenue", 8, 50, "property", 3, 120);
        properties[10][0] = new Property(new Color(240, 230, 200), "Jail", 0, 0, "neutral", 0, 0);
        
        properties[10][1] = new Property(new Color(204,68,204), "St. Charles Place", 10, 100, "property", 3, 140);
        properties[10][2] = new Property(new Color(240, 230, 200), "Electric Company", 0, 0, "utility", 2, 150);
        properties[10][3] = new Property(new Color(204,68,204), "States Avenue", 10, 100, "property", 3, 140);
        properties[10][4] = new Property(new Color(204,68,204), "Virginia Avenue", 12, 100, "property", 3, 160);
        properties[10][5] = new Property(Color.black, "Pennsylvania Railroad", 25, 0, "railroad", 4, 200);
        properties[10][6] = new Property(new Color(237, 115, 28), "St. James Place", 14, 100, "property", 3, 180);
        properties[10][7] = new Property(new Color(240, 230, 200), "Community Chest", 0, 0, "neutral", 0, 0);
        properties[10][8] = new Property(new Color(237, 115, 28), "Tennessee Avenue", 14, 100, "property", 3, 180);
        properties[10][9] = new Property(new Color(237, 115, 28), "New York Avenue", 16, 100, "property", 3, 200);
        properties[10][10] = new Property(new Color(240, 230, 200), "Free Parking", 0, 0, "neutral", 0, 0);
       
        properties[9][10] = new Property(new Color(255,0,0), "Kentucky Avenue", 18, 150, "property", 3, 220);
        properties[8][10] = new Property(new Color(240, 230, 200), "Chance", 0, 0, "neutral", 0, 0);
        properties[7][10] = new Property(new Color(255,0,0), "Indiana Avenue", 18, 150, "property", 3, 220);
        properties[6][10] = new Property(new Color(255,0,0), "Illinois Avenue", 20, 150, "property", 3, 240);
        properties[5][10] = new Property(Color.black, "B&O Railroad", 25, 0, "railroad", 4, 200);
        properties[4][10] = new Property(new Color(255,255,51), "Atlantic Avenue", 22, 150, "property", 3, 260);
        properties[3][10] = new Property(new Color(255,255,51), "Ventnor Avenue", 22, 150, "property", 3, 260);
        properties[2][10] = new Property(new Color(240, 230, 200), "Water Works", 0, 0, "utility", 2, 150);
        properties[1][10] = new Property(new Color(255,255,51), "Marvin Gardens", 24, 150, "property", 3, 280);
        properties[0][10] = new Property(new Color(240, 230, 200), "Go to Jail", 0, 0, "neutral", 0, 0);
        
        properties[0][9] = new Property(new Color(51,153,51), "Pacific Avenue", 26, 200, "property", 3, 300);
        properties[0][8] = new Property(new Color(51,153,51), "North Carolina Avenue", 26, 200, "property", 3, 300);
        properties[0][7] = new Property(new Color(240, 230, 200), "Community Chest", 0, 0, "neutral", 0, 0);
        properties[0][6] = new Property(new Color(51,153,51), "Pennsylvania Avenue", 28, 200, "property", 3, 320);
        properties[0][5] = new Property(Color.black, "Short Line Railroad", 25, 0, "railroad", 4, 200);
        properties[0][4] = new Property(new Color(240, 230, 200), "Chance", 0, 0, "neutral", 0, 0);
        properties[0][3] = new Property(Color.BLUE, "Park Place", 35, 200, "property", 2, 350);
        properties[0][2] = new Property(new Color(240, 230, 200), "Luxury Tax", 0, 0, "neutral", 0, 0);
        properties[0][1] = new Property(Color.BLUE, "Boardwalk", 50, 200, "property", 2, 400);

    }

}
