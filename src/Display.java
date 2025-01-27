import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {

    Property[][] properties = new Property[11][11];
    Button communityChest = new Button("Community Chest");

    public Display() {
        setTitle("Monopoly Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void drawBoard(Graphics2D g2d){
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
        drawCardPile(g2d);
    }

    private void drawCardPile(Graphics2D g2d) {
        
        communityChest.setBackground(new Color(0, 100, 200));
        communityChest.setBounds(200, 200, 100, 15);
        add(communityChest);
        
        
       
        // Draw card text
        g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
        FontMetrics fm = g2d.getFontMetrics();
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawString("Community Chest", 200, 230);

        // Draw card background
        g2d.setColor(new Color(0, 50, 200));
        g2d.fillRoundRect(200, 300, 100, 50, 15, 15);

        // Draw card text
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawString("Chance", 230, 330);
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
        g2d.setColor(new Color(240, 230, 200));
        int boardSize = 721;
        int cellSize = boardSize / 11;
        int startX = (getWidth() - boardSize) / 2;
        int startY = (getHeight() - boardSize) / 2;
        g2d.fillRect(50, 50, 75*11, 75*11);

        drawBoard(g2d);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Display game = new Display();
            game.setVisible(true);
        });
    }
}