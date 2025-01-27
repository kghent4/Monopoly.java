import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Display extends JFrame {

    Property[][] properties = new Property[11][11];
    JButton communityChest = new JButton("Community Chest");
    JButton chance = new JButton("Chance");


    public Display() {
        setLayout(null);
        setTitle("Monopoly Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        communityChest.setBackground(new Color(0, 100, 200));
        communityChest.setBounds(200, 200, 100, 50);
        add(communityChest);

        chance.setBackground(new Color(0, 100, 200));
        chance.setBounds(200, 300, 100, 50);
        add(chance);

        communityChest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Display.this, "Button Clicked!");
            }
        });

        chance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Display.this, "Button Clicked!");
            }
        });
    }

    public void drawBoard(Graphics2D g2d){
        g2d.setColor(new Color(240, 230, 200));
        g2d.fillRect(50, 50, 75*11, 75*11);
        g2d.setColor(Color.BLACK);
        for(int i = 0; i < properties.length; i++){
            for(int j = 0; j < properties[i].length; j++){
                if(i == 0 || i == 10 || j == 0 || j == 10){
                    g2d.drawRect(i * 75 + 50, j * 75 + 50, 75, 75);
                    if(properties[i][j] == null){
                        properties[i][j] = new Property();////////////////TODO
                    }

                    drawProperty(properties[i][j], g2d, i, j);
                }
            }
        }
    }

    private void drawProperty(Property p, Graphics2D g2d, int x, int y) {
        // Draw color bar
        g2d.setColor(p.getColor()); 
        g2d.fillRect(x*75 + 50, y*75+50, 75, (75 / 4));
 
        // Draw property name and outline
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString(p.getName(), x*75+50, y *75+65);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw the board background TODO
        

        drawBoard(g2d);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Display game = new Display();
            game.setVisible(true);
        });
    }
}