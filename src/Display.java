import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame {

    static Property[][] properties = new Property[11][11];
    static JButton communityChest = new JButton("Community Chest");
    static JButton chance = new JButton("Chance");
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
                        g2d.drawRect(i * 75, j * 75, 75, 75);
                        if (properties[i][j] != null) {
                            drawProperty(properties[i][j], g2d, i, j);
                        }
                    }
                }
            }
        }

        private void drawProperty(Property p, Graphics2D g2d, int x, int y) {
            // Draw color bar
            g2d.setColor(p.getColor());
            g2d.fillRect(x * 75, y * 75, 75, 75 / 4);

            // Draw property name
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
            FontMetrics fm = g2d.getFontMetrics();
            g2d.drawString(p.getName(), x * 75 + 5, y * 75 + 65);
        }
    };

    public static void setupFrame() {
        JFrame frame = new JFrame("Monopoly Game");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null); // Allow manual positioning

        // Configure buttons
        communityChest.setBackground(new Color(0, 100, 200));
        communityChest.setBounds(200, 200, 150, 50);
        frame.add(communityChest);

        chance.setBackground(new Color(0, 100, 200));
        chance.setBounds(200, 300, 150, 50);
        frame.add(chance);

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

}
