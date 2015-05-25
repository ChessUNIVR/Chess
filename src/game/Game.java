package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Emil Tomellini
 * @author Matteo Brentegani
 */
public class Game extends JFrame implements ActionListener {

    private JPanel chess;   //For draw the game
    private JPanel gui;     //For see information about current game
    private Dimension screenSize;
    private int width;
    private int height;
    public Scacchiera sc;
    

    private Image img;

    /**
     * @param args
     */

    public Game() {
        super("Project Chess");
        sc = new game.Scacchiera();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class ImagePanel extends JPanel {

        private Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, width * 3 / 4, height, null);
        }

    }

}