package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Pieces.Pezzo;
import game.Scacchiera;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Matteo
 */
public class MainWind implements MouseListener {
    
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private Bottone[][] chessBoardSquares = new Bottone[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    private Scacchiera game;
    private Bottone botsel;
    private String select;
    private boolean selectMove;
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    public static final int BLACK = 0, WHITE = 1;

    MainWind() {        
        initializeGui();
        game = new Scacchiera();
    }

    public final void initializeGui() {
        // create the images for the chess pieces
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("New") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        Action exitGameAction = new AbstractAction("Exit") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        Action resignGameAction = new AbstractAction("Resign") {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TO DO
            }
        };
        tools.add(newGameAction);
        tools.add(resignGameAction); // TODO - add functionality!
        tools.addSeparator();
        tools.add(exitGameAction);

        chessBoard = new JPanel(new GridLayout(0, 9)) {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8), 
                null
                ));
        // Set the BG to be dark
        Color dark = new Color(205,133,63);
        chessBoard.setBackground(dark);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(dark);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                Bottone b = new Bottone();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
                chessBoardSquares[jj][ii].addMouseListener(this);
                chessBoardSquares[jj][ii].setXY(jj, ii);
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    private final void createImages() {
        try {       	
            BufferedImage bi = ImageIO.read(new File("Resources/Pedine.png"));

            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Initializes the icons of the initial chess board piece places
     */
    private final void setupNewGame() {
        //dopo l'inizializzazione dovremmo creare una matrice che contiene tutte le posizioni cosi ci  è piu facile 
        //riolvere i movimenti
        // set up the black pieces
        selectMove = false;
        chessBoardSquares[0][0].setName("ROOKb");
        chessBoardSquares[1][0].setName("KNIGHTb");
        chessBoardSquares[2][0].setName("BISHOPb");
        chessBoardSquares[3][0].setName("QUEENb");
        chessBoardSquares[4][0].setName("KINGb");
        chessBoardSquares[5][0].setName("BISHOPb");
        chessBoardSquares[6][0].setName("KNIGHTb");
        chessBoardSquares[7][0].setName("ROOKb");        
        chessBoardSquares[0][7].setName("ROOKw");
        chessBoardSquares[1][7].setName("KNIGHTw");
        chessBoardSquares[2][7].setName("BISHOPw");
        chessBoardSquares[3][7].setName("QUEENw");
        chessBoardSquares[4][7].setName("KINGw");
        chessBoardSquares[5][7].setName("BISHOPw");
        chessBoardSquares[6][7].setName("KNIGHTw");
        chessBoardSquares[7][7].setName("ROOKw");
        chessBoardSquares[0][1].setName("PAWNb");
        chessBoardSquares[1][1].setName("PAWNb");
        chessBoardSquares[2][1].setName("PAWNb");
        chessBoardSquares[3][1].setName("PAWNb");
        chessBoardSquares[4][1].setName("PAWNb");
        chessBoardSquares[5][1].setName("PAWNb");
        chessBoardSquares[6][1].setName("PAWNb");
        chessBoardSquares[7][1].setName("PAWNb");
        chessBoardSquares[0][6].setName("PAWNw");
        chessBoardSquares[1][6].setName("PAWNw");
        chessBoardSquares[2][6].setName("PAWNw");
        chessBoardSquares[3][6].setName("PAWNw");
        chessBoardSquares[4][6].setName("PAWNw");
        chessBoardSquares[5][6].setName("PAWNw");
        chessBoardSquares[6][6].setName("PAWNw");
        chessBoardSquares[7][6].setName("PAWNw");
        
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][1].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][6].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][PAWN]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][7].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
    }
    public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWind frame = new MainWind();
                
                JFrame f = new JFrame("Chess");
                f.add(frame.getGui());
                f.setExtendedState(f.MAXIMIZED_BOTH);
                f.setUndecorated(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
         });
    }    

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Bottone bot = (Bottone) me.getComponent();
        if(selectMove) {
            //prendere le cooordinate del pezzo e dove deve andare
            JOptionPane.showMessageDialog(null, "true");
            if (game.move(bot.getXb(), bot.getYb(), game.matrix[botsel.getXb()][botsel.getYb()]) == 1) 
                JOptionPane.showMessageDialog(null,  game.matrix[botsel.getXb()][botsel.getYb()].getType());
            selectMove = false;
        } else {
            //Devo aggiungere una if di controllo per sapere se clica su un'altra peddine del medesimo colore
            //in modo tale da selezionare un'altra pedina della scacchiera
            select = me.getComponent().getName();
            botsel = (Bottone) me.getComponent();
            selectMove = true;
        }
        //e metti a true la variabile sempre se il pezzo è tuo
        //JOptionPane.showMessageDialog(null, select);
        //}      
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) { }

    @Override
    public void mouseExited(MouseEvent me) { }

}

