import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

//TODO fix property assets display font size
//TODO fix property assets display backdrop color for utilities

public class Display extends JFrame {

    static Property[][] properties = new Property[11][11];
    static ArrayList<Player> players = new ArrayList<>(1);
    static JButton communityChest = new JButton("Community Chest");
    static JButton chance = new JButton("Chance");
    static JLabel diceDisplay = new JLabel();
    static JFrame frame = new JFrame("Monopoly Game");

    static int squareLength = 75;
    static int numSquaresInRow = 11;

    static JPanel boardPanel = new JPanel() {
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the board background
            g2d.setColor(new Color(240, 230, 200));
            g2d.fillRect(0, 0, squareLength * numSquaresInRow, squareLength * numSquaresInRow);

            // Draw grid and properties
            g2d.setColor(Color.BLACK);
            for (int i = 0; i < properties.length; i++) {
                for (int j = 0; j < properties[i].length; j++) {
                    if (i == 0 || i == 10 || j == 0 || j == 10) {
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(i * squareLength, j * squareLength, squareLength, squareLength);

                        if (properties[i][j] != null) {
                            drawProperty(properties[i][j], g2d, i, j);
                        }
                         
                    }
                }
            }

            //Draw player assets
            drawPlayerAssets(g2d);
            drawPlayers(g2d);
        }

        public void drawPlayers(Graphics g2d){
            
            g2d.setFont(new Font("SansSerif", Font.PLAIN, (squareLength/6)));
            if(players != null && !players.isEmpty()){
                int playerOffset = 1;
                for(Player p:players){
                    int xoffset = 0;
                    int yoffset = 0;

                    //top row
                    if(p.getLocation() < 11){
                        xoffset = p.getLocation() * squareLength;
                    }

                    //bottom row 
                    else if(p.getLocation() > 19 && p.getLocation() < 31){
                        xoffset = (10-(p.getLocation()-20)) * squareLength;
                        yoffset = squareLength * 10;
                    }

                    //right side
                    else if(p.getLocation() > 10 && p.getLocation() < 20){
                        yoffset = (p.getLocation()-10) * squareLength;
                        xoffset = squareLength * 10;
                    }

                    else if(p.getLocation() > 30 && p.getLocation() < 40){

                        yoffset = (40 - p.getLocation()) * squareLength;
                        xoffset = 0;
                    }

                    else{
                        System.out.println("Invalid player location.");
                    }

                    g2d.setColor(new Color(255, 0, 255));
                    g2d.fillOval(xoffset + playerOffset * (int)(squareLength/4) - squareLength/5, (int)(yoffset + squareLength / 2.5), squareLength / 5, squareLength / 5);
                    g2d.setColor(new Color(255, 255, 255));
                    g2d.drawString(Integer.toString(playerOffset), xoffset + playerOffset * (int)(squareLength/4) - squareLength/7, yoffset + (int)(squareLength/1.75));

                    playerOffset += 1;
                }
            }
        }

        private void drawProperty(Property p, Graphics2D g2d, int x, int y) {

            // Draw color bar
            g2d.setColor(p.getColor());
            g2d.fillRect(x * squareLength, y * squareLength, squareLength, squareLength / 4);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x * squareLength, y * squareLength, squareLength, squareLength / 4);

            // Draw property name
            int nameOffset = y * squareLength + (int)(squareLength * .90);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.PLAIN, (int)(.13*squareLength)));//10
            if(p.getName().length() > 12){
                String[] names = p.getName().split(" ");
                if(names.length == 3){
                    nameOffset -= 10;
                    g2d.drawString(names[0] + names[1], x * squareLength + 5, nameOffset);
                    nameOffset += 10;
                    g2d.drawString(names[2], x * squareLength + 5, nameOffset);
                }
                else{
                    nameOffset -= 10;
                    g2d.drawString(names[0], x * squareLength + 5, nameOffset);
                    nameOffset += 10;
                    g2d.drawString(names[1], x * squareLength + 5, nameOffset);
                }

            }
            else{
                g2d.drawString(p.getName(), x * squareLength + 5, nameOffset);
            }
            

            //Draw houses
            g2d.setColor(new Color(50, 168, 82));
            int offset = 0;
            for(int i = 0; i < p.getNumHouses(); i++){
                g2d.fillOval(x * squareLength + offset, y*squareLength, 10, 10);
                offset += 10;
            }
        }

        private void drawPlayerAssets(Graphics2D g2d) {

            int playerOffset = 0;
            int propertyOffset;

            if(players != null && !players.isEmpty()){
                for(Player player: players){
                    propertyOffset = squareLength / 4;
                    g2d.setColor(Color.BLACK);
                    g2d.setFont(new Font("SansSerif", Font.PLAIN, (squareLength/5)));

                    g2d.drawString(player.getName(), (int)(squareLength * 2) + playerOffset, (int)(squareLength * 3.5));
                    g2d.drawString("$" + player.getMoney(), (int)(squareLength * 2) + playerOffset, (int)(squareLength * 3.5) + squareLength / 4);


                    if(player.getProperties() != null && !player.getProperties().isEmpty()){
                        for(Property property : player.getProperties()){
                            g2d.setColor(property.getColor());
                            g2d.fillRect((int)(squareLength * 2) + playerOffset, squareLength * 4 + propertyOffset, squareLength, squareLength / 4);

                            // Draw property name
                            g2d.setColor(Color.WHITE);
                            g2d.drawString(property.getName(), squareLength * 2 + playerOffset, squareLength * 4 + propertyOffset + squareLength / 5);

                            propertyOffset += (int)(squareLength / 3.75);
                        }

                       
                    }

                    playerOffset += squareLength * 2;
                }
            }
        }
    };

    public static void setupFrame() {

        frame.setSize(squareLength * 14, squareLength * 14);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null); // Allow manual positioning

        // Configure buttons
        communityChest.setBackground(new Color(0, 100, 200));
        communityChest.setBounds((int)(squareLength * 2.5), (int)(squareLength * 2.5), squareLength * 2, squareLength);
        communityChest.setFont(new Font("SansSerif", Font.PLAIN, (squareLength /6)));
        frame.add(communityChest);

        chance.setBackground(new Color(0, 100, 200));
        chance.setBounds((int)(squareLength * 5.5), (int)(squareLength * 2.5), squareLength * 2, squareLength);
        chance.setFont(new Font("SansSerif", Font.PLAIN, (squareLength /5)));
        frame.add(chance);

        //Config dice display
        diceDisplay.setBounds((int)(squareLength * 8.5), (int)(squareLength * 2.5), squareLength * 2, squareLength);
        diceDisplay.setBackground(new Color(255, 255, 255));
        diceDisplay.setFont(new Font("SansSerif", Font.PLAIN, (squareLength /5)));
        diceDisplay.setText("No rolls yet!");
        frame.add(diceDisplay);

        communityChest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Community Chest Button Clicked!");
            }
        });

        chance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Chance Button Clicked!");
            }
        });

        // Add the custom board
        boardPanel.setBounds(50, 50, 900, 900);
        frame.add(boardPanel);
        frame.setVisible(true);
    }

    public static void inform(String text){
        JOptionPane.showMessageDialog(frame, text);
    }

    public static void inform(String title, String text){
        JOptionPane.showMessageDialog(frame, text, title, 0);
    }

    public static int choice(String title, String text, String[] options){
        return JOptionPane.showOptionDialog(frame,
                                            text,
                                            title,
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[0]);
    }

    public static void setDiceDisplay(String text){
        diceDisplay.setText(text);
    }
}
