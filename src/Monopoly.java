import javax.swing.SwingUtilities;

public class Monopoly {
    public static void main(String[] args) {

        Board b = new Board();
        Display.players.add(new Player());
        Display.players.add(new Player());
        Display.players.add(new Player());
        Display.players.add(new Player());

        //Graphics!
        SwingUtilities.invokeLater(() -> Display.setupFrame());
    }
}
