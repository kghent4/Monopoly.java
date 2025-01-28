import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Display extends JFrame {

    static Property[][] properties = new Property[11][11];
    static ArrayList<Player> players = new ArrayList<Player>(1);
    static JButton communityChest = new JButton("Community Chest");
    static JButton chance = new JButton("Chance");
    static JLabel diceDisplay = new JLabel();
    static JFrame frame = new JFrame("Monopoly Game");
    static JPanel boardPanel = new JPanel() {
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw the board background
            g2d.setColor(new Color(240, 230, 200));
            g2d.fillRect(0, 0, 75 * 11, 75 * 11);

            // Draw grid and properties
            g2d.setColor(Color.BLACK);
            for (int i = 0; i < properties.length; i++) {
                for (int j = 0; j < properties[i].length; j++) {
                    if (i == 0 || i == 10 || j == 0 || j == 10) {
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(i * 75, j * 75, 75, 75);
                       /*  if (properties[i][j] == null) {
                            properties[i][j] = new Property();
                            
                        }
                        drawProperty(properties[i][j], g2d, i, j);
                        for testing*/
                         if (properties[i][j] != null) {
                            drawProperty(properties[i][j], g2d, i, j);
                        }
                         
                    }
                }
            }

            //Draw player assets
            drawPlayerAssets(g2d);
        }

        private void drawProperty(Property p, Graphics2D g2d, int x, int y) {

            // Draw color bar
            g2d.setColor(p.getColor());
            g2d.fillRect(x * 75, y * 75, 75, 75 / 4);

            // Draw property name
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g2d.drawString(p.getName(), x * 75 + 5, y * 75 + 65);

            //Draw houses
            g2d.setColor(new Color(50, 168, 82));
            int offset = 0;
            for(int i = 0; i < p.getNumHouses(); i++){
                g2d.fillOval(x * 75 + offset, y*75, 10, 10);
                offset += 10;
            }
        }

        private void drawPlayerAssets(Graphics2D g2d) {

           // System.out.println(players.size());
            
            int playerOffset = 0;
            int propertyOffset = 25;

            if(!players.isEmpty()){
                for(Player player: players){
                    
                    propertyOffset = 25;
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(player.getName(), 150 + playerOffset, 300);
                    g2d.drawString("$" + player.getMoney(), 150 + playerOffset, 300 + 18);


                    if(player.getProperties() != null && !player.getProperties().isEmpty()){
                        for(Property property : player.getProperties()){
                            g2d.setColor(property.getColor());
                            g2d.fillRect(150 + playerOffset, 300 + propertyOffset, 75, 75 / 4);

                            // Draw property name
                            g2d.setColor(Color.BLACK);
                            g2d.drawString(property.getName(), 150 + playerOffset, 300 + propertyOffset + 15);

                            propertyOffset += 20;
                        }

                        playerOffset += 150;
                    }
                }
            }
        }
    };

    public static void setupFrame() {

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null); // Allow manual positioning

        // Configure buttons
        communityChest.setBackground(new Color(0, 100, 200));
        communityChest.setBounds(200, 200, 150, 50);
        frame.add(communityChest);

        chance.setBackground(new Color(0, 100, 200));
        chance.setBounds(400, 200, 150, 50);
        frame.add(chance);

        //Config dice display
        diceDisplay.setBounds(600, 200, 100, 100);
        diceDisplay.setBackground(new Color(255, 255, 255));
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

    public static void landOnUnownedProperty(Property p){
        JOptionPane.showMessageDialog(frame, "You can buy this property!");
    }

    public static void landOnOwnedProperty(Property p){
        JOptionPane.showMessageDialog(frame, "You owe " + p.getOwner() + " $" + p.getRent() + " in rent.");
    }

    public static void landOnSpecialProperty(Property p, String text){
        JOptionPane.showMessageDialog(frame, text);
    }
}
